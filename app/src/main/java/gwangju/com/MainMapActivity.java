package gwangju.com;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gwangju.com.data.GpsInfo;
import gwangju.com.data.dto.JavaRoomsDto;

public class MainMapActivity extends FragmentActivity implements MapView.OpenAPIKeyAuthenticationResultListener, MapView.MapViewEventListener,MapView.POIItemEventListener {
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

        chkGpsService();
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
