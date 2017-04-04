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
import gwangju.com.adapter.ThemeListViewAdapter;
import gwangju.com.list.JavaRoomsDto;
import gwangju.com.list.RoomsData;
import gwangju.com.list.RoomsListViewItem;
import gwangju.com.list.ThemeListViewItem;

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

        adapter.addItem_title("종류", "숙소이름");
        for(int i =0; i< list.size(); i++){
            adapter.addItem( list.get(i).getKind(), list.get(i).getName(),
                    list.get(i).getLat(),list.get(i).getLng(), list.get(i).getLocation(),
                    list.get(i).getPhoneNum(), list.get(i).getFeeMax()+"",list.get(i).getFeeMin()+"");

        }

        roomsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                JavaRoomsDto item = (JavaRoomsDto) parent.getItemAtPosition(position);

                String roomsName = item.getName();
                String lat =item.getLat();

                Intent intent = new Intent(RoomsSelectActivity.this, SeletedRoomsActivity.class);
                intent.putExtra("item",item);
                startActivity(intent);
            }
        });
    }
}
