package gwangju.com;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.List;

import gwangju.com.data.GpsInfo;
import gwangju.com.data.dao.RoomsData;
import gwangju.com.data.dto.JavaRoomsDto;

public class MapActivity extends FragmentActivity implements MapView.OpenAPIKeyAuthenticationResultListener, MapView.MapViewEventListener,MapView.POIItemEventListener {
    JavaRoomsDto item;
    List<JavaRoomsDto> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Log.e("넘어옴", "숙소맵뷰로");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TextView lat = (TextView) findViewById(R.id.lat);
        TextView lng = (TextView) findViewById(R.id.lng);

        Intent intent = getIntent();
        item = (JavaRoomsDto) intent.getSerializableExtra("item");
        Double latD = Double.parseDouble(item.getLat());
        Double lngD = Double.parseDouble(item.getLng());

        setTitle(item.getName());
        lat.setText(latD + "");
        lng.setText(lngD + "");

        //다음이 제공하는 MapView객체 생성 및 API Key 설정
        final MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey("162e50dd06bf165275d1555f498baf29");
//        mapView.setOpenAPIKeyAuthenticationResultListener((MapView.OpenAPIKeyAuthenticationResultListener) this);
//        mapView.setMapViewEventListener((MapViewEventListener) this);
//        mapView.setPOIItemEventListener((MapView.POIItemEventListener) this);
//        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(35.1610868,126.8774441
//        ), true);
        //xml에 선언된 map_view 레이아웃을 찾아온 후, 생성한 MapView객체 추가
        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);
        container.addView(mapView);
        Log.e("띄움", "맵뷰를");



//        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latD, lngD), true);

    }

    @Override
    public void onMapViewInitialized(final MapView mapView) {
        GpsInfo gps =new GpsInfo(this);
        final double lat = gps.getLatitude();
        final double lng = gps.getLongitude();


        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithCONGCoord(lat,lng), 3, false);

        new Thread(new Runnable() {
            @Override
            public void run() {
                RoomsData data = new RoomsData();
                list= data.getRoomsGeocode(lat,lng);
                    for(int i =0; i<list.size(); i++) {
                        MapPOIItem marker = new MapPOIItem();
                        marker.setTag(i);
                        marker.setItemName("숙소");
                        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(Double.parseDouble(list.get(i).getLat()), Double.parseDouble(list.get(i).getLng())));
                        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
                        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

                        mapView.addPOIItem(marker);
                    }
            }
        });
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
