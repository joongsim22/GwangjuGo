package gwangju.com;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import gwangju.com.adapter.RoomsListViewAdapter;
import gwangju.com.item.RoomsXMLItem;

public class RoomsSelectActivity extends AppCompatActivity {
//    List<JavaRoomsDto> list;
        ListView roomsList;
    ArrayList<RoomsXMLItem> list;
    RoomsListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_select);
        setTitle("숙소정보");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        adapter = new RoomsListViewAdapter();

        roomsList = (ListView)findViewById(R.id.roomsListView);
        roomsList.setAdapter(adapter);
        RoomsXML item = new RoomsXML();
        list = item.getData();
        adapter.addItem_title("종류", "숙소이름");
        for(int i =0; i< list.size(); i++){
            adapter.addItem(list.get(i));
        }
        Spinner s = (Spinner)findViewById(R.id.spinner1);
        //어댑터 생성

        //이 예제 같은 경우 string,xml에 리스트를 추가해 놓고 그 리스트를 불러온다.

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.rooms, android.R.layout.simple_spinner_item);
        s.setAdapter(adapter);


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("스피너클릭", list.get(position).getLodgName());
                //포지션이 고정되어 있군...

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



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
