package gwangju.com;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import gwangju.com.adapter.ThemeListViewAdapter;
import gwangju.com.adapter.ThemeViewPagerAdapter;
import gwangju.com.list.ThemeListViewItem;

public class ThemeSelectActivity extends AppCompatActivity {

    ViewPager themePager;
    private ArrayList<ThemeListViewItem> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_select);
        setTitle("테마관광");

        setLayout();

        mGroupList = new ArrayList<ThemeListViewItem>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();

        ThemeListViewItem item1 = new ThemeListViewItem("버스", "버스노선을 따라 광주를 여행하세요.");
        mGroupList.add(item1);
        mChildListContent.add("518");
        mChildListContent.add("7");
        mChildListContent.add("18");
        mChildList.add(mChildListContent);

        ThemeListViewItem item2 = new ThemeListViewItem("문화예술", "박물관 등 각종 시설을 알려드립니다.");
        mGroupList.add(item2);
        mChildList.add(mChildListContent);

        ThemeListViewItem item3 = new ThemeListViewItem("역사", "광주의 역사를 두 발로 걸어보세요.");
        mGroupList.add(item3);
        mChildList.add(mChildListContent);

        ThemeListViewItem item4 = new ThemeListViewItem("자연", "광주의 푸르른 자연을 느껴보세요.");
        mGroupList.add(item4);
        mChildList.add(mChildListContent);

        mListView.setAdapter(new ThemeListViewAdapter(this, mGroupList, mChildList));

        // 차일드 클릭 했을 경우 이벤트
        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String title = mChildList.get(groupPosition).get(childPosition);
                Intent intent = new Intent(ThemeSelectActivity.this, SeletedThemeActivity.class);
                intent.putExtra("themeTitle", title);
                startActivity(intent);
                return false;
            }
        });

        // 사진 뷰페이저
        int imgCnt = 2;
        themePager = (ViewPager)findViewById(R.id.themePager);
        ThemeViewPagerAdapter themeAdapter = new ThemeViewPagerAdapter(getLayoutInflater(), imgCnt);
        themePager.setAdapter(themeAdapter);

    }

    /*
     * Layout
     */
    private ExpandableListView mListView;

    private void setLayout(){
        mListView = (ExpandableListView) findViewById(R.id.themeListView);
    }

}
