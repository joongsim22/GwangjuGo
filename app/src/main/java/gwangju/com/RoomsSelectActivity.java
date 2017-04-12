package gwangju.com;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import gwangju.com.adapter.RoomsListViewAdapter;
import gwangju.com.item.RoomsXMLItem;

public class RoomsSelectActivity extends AppCompatActivity {
//    List<JavaRoomsDto> list;
    ArrayList<RoomsXMLItem> list;
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
        RoomsXML item = new RoomsXML();
        list = item.getData();

        adapter.addItem_title("종류", "숙소이름");
        for(int i =0; i< list.size(); i++){
            adapter.addItem(list.get(i));
        }

        roomsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                RoomsXMLItem item = (RoomsXMLItem) parent.getItemAtPosition(position);

                Intent intent = new Intent(RoomsSelectActivity.this, SeletedRoomsActivity.class);
                intent.putExtra("item",item);
                startActivity(intent);
            }
        });
    }
}
