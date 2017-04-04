package gwangju.com;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import gwangju.com.adapter.RoomsListViewAdapter;
import gwangju.com.data.JavaRoomsDto;
import gwangju.com.data.RoomsData;

public class RoomsSelectActivity extends AppCompatActivity {
    List<JavaRoomsDto> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_select);
        setTitle("숙소정보");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ListView roomsList;
        RoomsListViewAdapter adapter = new RoomsListViewAdapter();

        roomsList = (ListView)findViewById(R.id.roomsListView);
        roomsList.setAdapter(adapter);
        RoomsData room = new RoomsData();
        list = room.getAllinfo();

        adapter.addItem("호텔", "숙소1");
        for(int i =0; i< list.size(); i++){
            adapter.addItem( list.get(i).getKind(), list.get(i).getName());
            Log.e("DD",list.get(0).getKind());

        }

        roomsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                JavaRoomsDto item = (JavaRoomsDto) parent.getItemAtPosition(position);

                String roomsName = item.getName();

                Intent intent = new Intent(RoomsSelectActivity.this, SeletedRoomsActivity.class);
                intent.putExtra("item",item);
//                Log.e("#########넘기는값",themeTitle + "");
                startActivity(intent);
            }
        });
    }
}
