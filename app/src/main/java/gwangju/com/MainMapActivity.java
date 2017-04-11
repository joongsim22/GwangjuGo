package gwangju.com;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;

import java.util.List;

import gwangju.com.data.GpsInfo;
import gwangju.com.data.dao.OmeGwangjuData;
import gwangju.com.data.dto.OmeGwangjuDto;
import gwangju.com.item.RoomsXMLItem;

public class MainMapActivity extends FragmentActivity implements MapView.OpenAPIKeyAuthenticationResultListener, MapView.POIItemEventListener, MapView.MapViewEventListener {
    RoomsXMLItem item;
    List<RoomsXMLItem> list;
    List<OmeGwangjuDto> omelist;
    GpsInfo gps = null;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Log.e("넘어옴", "숙소맵뷰로");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TextView lat = (TextView) findViewById(R.id.lat);
        TextView lng = (TextView) findViewById(R.id.lng);




//
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
            // 최초 권한 요청인지, 혹은 사용자에 의한 재요청인지 확인
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                // 사용자가 임의로 권한을 취소시킨 경우
                // 권한 재요청
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            } else {
                // 최초로 권한을 요청하는 경우(첫실행)
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }else {
            // 사용 권한이 있음을 확인한 경우
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }

    }
    private boolean chkGpsService() {

        String gps = android.provider.Settings.Secure.getString(
                getContentResolver(),
                android.provider.Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        Log.d(gps, "aaaa");

        if (!(gps.matches(".*gps.*") && gps.matches(".*network.*"))) {

            // GPS OFF 일때 Dialog 표시
            AlertDialog.Builder gsDialog = new AlertDialog.Builder(this);
            gsDialog.setTitle("위치 서비스 설정");
            gsDialog.setMessage("무선 네트워크 사용, GPS 위성 사용을 모두 체크하셔야 정확한 위치 서비스가 가능합니다.\n위치 서비스 기능을 설정하시겠습니까?");
            gsDialog.setPositiveButton("설정",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // GPS설정 화면으로 이동
                            Intent intent = new Intent(
                                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            intent.addCategory(Intent.CATEGORY_DEFAULT);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("취소",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    return;
                                }
                            }).create().show();
            return false;

        } else {
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                //권한 획득이 거부되면 결과 배열은 비어있게 됨
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //권한 획득이 허용되면 수행해야 할 작업이 표시됨
                    //일반적으로 작업을 처리할 메서드를 호출
                    if (gps == null) {
                        gps = new GpsInfo(MainMapActivity.this);
                    } else {
                        gps.Update();
                    }

                    // check if GPS enabled
                    if (gps.canGetLocation()) {

                        MapView mapView = new MapView(this);
                        mapView.setPOIItemEventListener(MainMapActivity.this);
                        mapView.setMapViewEventListener(MainMapActivity.this);
                        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);
                        mapView.setDaumMapApiKey("162e50dd06bf165275d1555f498baf29");
                        container.addView(mapView);
                        Log.e("띄움", "맵뷰를");

                        double latitude = gps.getLatitude();
                        double longitude = gps.getLongitude();
                        //다음이 제공하는 MapView객체 생성 및 API Key 설정




                        // \n is for new line
                        Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();

//                        mapView.setMapCenterPoint(mapPoint,true);


                    } else {
                        // can't get location
                        // GPS or Network is not enabled
                        // Ask user to enable GPS/network in settings
                        chkGpsService();
                    }
                } else {

                    Toast.makeText(MainMapActivity.this, "권한을 설정해주셔야 사용이 가능합니다.", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }


    @Override
    public void onMapViewInitialized(MapView mapView) {
        double latitude = gps.getLatitude();
        double longitude = gps.getLongitude();


        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(latitude, longitude);
        mapView.setZoomLevel(3, true);
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(latitude, longitude), 4, true);

//        OmeGwangjuData gwangjuData = new OmeGwangjuData();
//        omelist = gwangjuData.getAllOmeGwangjuinfo();
//        for(int i =0; i<omelist.size(); i++){
//            MapPOIItem customMarker = new MapPOIItem();
//            customMarker.setItemName(omelist.get(i).getName());
//            customMarker.setTag(i);
//            customMarker.setMapPoint(MapPoint.mapPointWithGeoCoord(
//                    Double.parseDouble(omelist.get(i).getLat()),
//                    Double.parseDouble(omelist.get(i).getLng())));
//            customMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
//            // 마커타입을 커스텀마커 지정.
//            customMarker.setCustomImageResourceId(R.drawable.touricon); // 마커이미지.
//            customMarker.setCustomImageAutoscale(false);
//            // hdpi, xhdpi 등 안드로이드 플랫폼의 스케일을 사용할 경우 지도 라이브러리의 스케일 기능을 꺼줌.
//            mapView.addPOIItem(customMarker);
//
//        }
        //숙박 아이콘 찍기
        RoomsXML roomsXML = new RoomsXML();
        list = roomsXML.getData();
        for(int i =0; i<list.size(); i++){
            MapPOIItem customMarker = new MapPOIItem();
            customMarker.setItemName(list.get(i).getTitle());
            customMarker.setTag(i);
            customMarker.setMapPoint(MapPoint.mapPointWithGeoCoord(
                    Double.parseDouble(list.get(i).getLat()),
                    Double.parseDouble(list.get(i).getLon())));
            customMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
            // 마커타입을 커스텀마커 지정.
            customMarker.setCustomImageResourceId(R.drawable.roomsicon); // 마커이미지.
            customMarker.setCustomImageAutoscale(false);
            // hdpi, xhdpi 등 안드로이드 플랫폼의 스케일을 사용할 경우 지도 라이브러리의 스케일 기능을 꺼줌.
            mapView.addPOIItem(customMarker);
        }

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onDaumMapOpenAPIKeyAuthenticationResult(MapView mapView, int i, String s) {

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }
}
