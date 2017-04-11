package gwangju.com;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.List;

import gwangju.com.data.GpsInfo;
import gwangju.com.item.RoomsXMLItem;

public class MainMapActivity extends FragmentActivity implements MapView.OpenAPIKeyAuthenticationResultListener, MapView.MapViewEventListener,MapView.POIItemEventListener {
    RoomsXMLItem item;
    List<RoomsXMLItem> list;
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



// 권한을 획득하기전에 현재 Acivity에서 지정된 권한을 사용할 수 있는지 여부 체크
        if (ContextCompat.checkSelfPermission(MainMapActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // 권한 획득에 대한 설명 보여주기
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainMapActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // 사용자에게 권한 획득에 대한 설명을 보여준 후 권한 요청을 수행

            } else {

                // 권한 획득의 필요성을 설명할 필요가 없을 때는 아래 코드를
                //수행해서 권한 획득 여부를 요청한다.

                ActivityCompat.requestPermissions(MainMapActivity.this,
                        PERMISSIONS_STORAGE,
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            }
        }










//        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latD, lngD), true);

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
                    if(gps == null) {
                        gps = new GpsInfo(MainMapActivity.this);
                    }else{
                        gps.Update();
                    }

                    // check if GPS enabled
                    if(gps.canGetLocation()){

                        double latitude = gps.getLatitude();
                        double longitude = gps.getLongitude();
                        //다음이 제공하는 MapView객체 생성 및 API Key 설정
                        final MapView mapView = new MapView(this);
                        mapView.setDaumMapApiKey("162e50dd06bf165275d1555f498baf29");
//        mapView.setOpenAPIKeyAuthenticationResultListener((MapView.OpenAPIKeyAuthenticationResultListener) this);
//        mapView.setMapViewEventListener((MapViewEventListener) this);
//        mapView.setPOIItemEventListener((MapView.POIItemEventListener) this);
                        //xml에 선언된 map_view 레이아웃을 찾아온 후, 생성한 MapView객체 추가
                        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);
                        container.addView(mapView);
                        Log.e("띄움", "맵뷰를");

                        MapPOIItem marker = new MapPOIItem();
                        marker.setItemName("Default Marker");
                        marker.setTag(0);
                        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude));
                        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
                        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

                        mapView.addPOIItem(marker);

                        // \n is for new line
                        Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                    }else{
                        // can't get location
                        // GPS or Network is not enabled
                        // Ask user to enable GPS/network in settings
                        chkGpsService();
                    }

                } else {

                    Toast.makeText(MainMapActivity.this, "권한을 설정해주셔야 사용이 가능합니다.",Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {

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
