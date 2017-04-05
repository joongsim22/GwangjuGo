package gwangju.com;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import gwangju.com.adapter.DetailFragmentAdapter;
import gwangju.com.item.DetailItem;
import gwangju.com.item.StarItem;

public class SeletedThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleted_theme);

        Intent intent = getIntent();
        String themeTitle = intent.getExtras().getString("themeTitle");
        setTitle(themeTitle);
//        Log.e("######넘어오는값",themeTitle + "");

        // 관광지 정보들. 사진, 요금, 소개 등등
        DetailItem data = new DetailItem(BitmapFactory.decodeResource(getResources(), R.drawable.cloud), themeTitle);
        data.setTime("9~18");
        data.setFee("2000");
        data.setAddress("광주광역시");
        data.setCall("01068255567");
        data.setIntroduce("아주 좋은 곳입니다.");

        // 별점 정보. 별점과 텍스트
        ArrayList<StarItem> starData = new ArrayList<StarItem>();
        StarItem i1 = new StarItem("아주 좋아요.", 4);
        StarItem i2 = new StarItem("즐거웠어요.", 5);
        StarItem i3 = new StarItem("평범해요.", 3);
        starData.add(i1);
        starData.add(i2);
        starData.add(i3);

        // 뷰페이저와 어댑터 연결
        ViewPager detailPager = (ViewPager)findViewById(R.id.detail_pager);
        DetailFragmentAdapter adapter = new DetailFragmentAdapter(getSupportFragmentManager(), data, starData);
        detailPager.setAdapter(adapter);

        // 상단에 탭바 놓기
        TabLayout detailTab = (TabLayout)findViewById(R.id.detail_tabs);
        detailTab.setupWithViewPager(detailPager);

    }
}
