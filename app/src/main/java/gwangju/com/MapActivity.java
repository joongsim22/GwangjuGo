package gwangju.com;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.daum.mf.map.api.MapView;

import gwangju.com.list.JavaRoomsDto;

public class MapActivity extends AppCompatActivity {
    JavaRoomsDto item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        TextView lat =(TextView)findViewById(R.id.lat);
        TextView lng =(TextView)findViewById(R.id.lng);

        Intent intent = getIntent();
        item= (JavaRoomsDto) intent.getSerializableExtra("item");
        setTitle(item.getName());
        lat.setText(item.getLat());
        lng.setText(item.getLng());

    //다음이 제공하는 MapView객체 생성 및 API Key 설정
        MapView mapView = new MapView(this); mapView.setDaumMapApiKey("162e50dd06bf165275d1555f498baf29");
        //xml에 선언된 map_view 레이아웃을 찾아온 후, 생성한 MapView객체 추가
        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view); container.addView(mapView);


    }
}
