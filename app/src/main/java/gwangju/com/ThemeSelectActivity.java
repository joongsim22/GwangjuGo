package gwangju.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import gwangju.com.adapter.ThemeListViewAdapter;
import gwangju.com.list.ThemeListViewItem;

public class ThemeSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_select);
        setTitle("테마관광");

        ListView themeList;
        ThemeListViewAdapter adapter = new ThemeListViewAdapter();

        themeList = (ListView)findViewById(R.id.themeListView);
        themeList.setAdapter(adapter);

        adapter.addItem("버스", "버스노선을 따라 광주를 여행하세요.");
        adapter.addItem("문화예술", "박물관 등 각종 시설을 알려드립니다.");
        adapter.addItem("역사", "광주의 역사를 두 발로 걸어보세요.");
        adapter.addItem("자연", "광주의 푸르른 자연을 느껴보세요.");


        themeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                ThemeListViewItem item = (ThemeListViewItem) parent.getItemAtPosition(position);

                String themeTitle = item.getThemeTitle();

                Intent intent = new Intent(ThemeSelectActivity.this, SeletedThemeActivity.class);
                intent.putExtra("themeTitle",themeTitle);
//                Log.e("#########넘기는값",themeTitle + "");
                startActivity(intent);
            }
        });
    }
}
