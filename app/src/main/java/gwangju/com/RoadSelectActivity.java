package gwangju.com;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import gwangju.com.adapter.RoadListViewAdapter;
import gwangju.com.data.dao.OmeGwangjuRoadData;
import gwangju.com.data.dto.OmeGwangjuRoadDto;

public class RoadSelectActivity extends AppCompatActivity {
    List<OmeGwangjuRoadDto> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_select);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ListView roadList;
        final RoadListViewAdapter adapter = new RoadListViewAdapter();

        roadList =(ListView)findViewById(R.id.listview1);
        roadList.setAdapter(adapter);

        adapter.addItem("518","5.18");
        adapter.addItem("광주시티투어","광주의 문화와 역사, 주요관광지를 편안하고 편리하게 관광할 수 있도록 한 광주 핵심관광");
        adapter.addItem("빛고을남도투어(광역시티투어)","광주와 인접한 5개시, 군의 도심관광, 체험관광, 자연관광을 연계한 테마형코스");
        adapter.addItem("훈이오빠 자전거도심여행","국립아시아문화전당에서 출발해 대인시장, 충장로, 동명동 카페거리까지 향하는 4개코스와 양림동 역사문화마을 거점으로 운행하는 1개코스. " +
                "관광 자전거 운전자는 자전거 지도사 자격증을 보유, 광주시 문화해설사 교육을 이수했다.");
        adapter.addItem("광주 미인을 찾아떠나는 다정다감 광주여행","다정다감 광주여행은 아시아문화전당 주변을 광주의 명사를 테마로 둘러보는 관광프로그램");

        roadList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                String title = adapter.getItem(position).toString();
                Intent intent = new Intent(RoadSelectActivity.this, SelectedRoadActivity.class);
                intent.putExtra("item",title);
                startActivity(intent);
            }
        });
    }
}
