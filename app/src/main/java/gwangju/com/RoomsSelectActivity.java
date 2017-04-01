package gwangju.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import gwangju.com.adapter.RoomsListViewAdapter;
import gwangju.com.adapter.ThemeListViewAdapter;
import gwangju.com.list.RoomsListViewItem;
import gwangju.com.list.ThemeListViewItem;

public class RoomsSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_select);
        setTitle("숙소정보");

        ListView roomsList;
        RoomsListViewAdapter adapter = new RoomsListViewAdapter();

        roomsList = (ListView)findViewById(R.id.roomsListView);
        roomsList.setAdapter(adapter);

        adapter.addItem("호텔", "숙소1");

        roomsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                RoomsListViewItem item = (RoomsListViewItem) parent.getItemAtPosition(position);

                String roomsTitle = item.getRoomsTitle();

                Intent intent = new Intent(RoomsSelectActivity.this, SeletedRoomsActivity.class);
                intent.putExtra("roomsTitle",roomsTitle);
//                Log.e("#########넘기는값",themeTitle + "");
                startActivity(intent);
            }
        });
    }
}
