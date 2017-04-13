package gwangju.com;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import gwangju.com.adapter.RoadListViewAdapter;
import gwangju.com.data.dao.OmeGwangjuRoadData;
import gwangju.com.data.dto.OmeGwangjuRoadDetailDto;
import gwangju.com.data.dto.OmeGwangjuRoadDto;
import gwangju.com.data.dto.OmeGwangjuRoadTotalDto;

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

        OmeGwangjuRoadData dao = new OmeGwangjuRoadData();

        list = dao.getAllRoadinfo();
        adapter.addItem_Nofee("5.18 올레");


        for(int i =0; i<list.size()-1; i++){
            adapter.addItem(list.get(i).getTourName(),list.get(i).getFee());
//            if(i==3){
//                adapter.addItem_Nofee(list.get(i).getTourName(),list.get(i).getEx());
//
//            }
        }
        adapter.addItem_Nofee(list.get(3).getTourName());


        roadList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {


            }
        });
    }
}
