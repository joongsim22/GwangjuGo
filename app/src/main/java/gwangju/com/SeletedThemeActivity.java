package gwangju.com;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import gwangju.com.adapter.DetailFragmentAdapter;
import gwangju.com.fragment.PictureFragment;
import gwangju.com.item.DetailItem;

public class SeletedThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleted_theme);

        Intent intent = getIntent();
        String themeTitle = intent.getExtras().getString("themeTitle");
        setTitle(themeTitle);
//        Log.e("######넘어오는값",themeTitle + "");
        DetailItem data = new DetailItem(BitmapFactory.decodeResource(getResources(), R.drawable.cloud), themeTitle);
        data.setTime("9~18");
        data.setFee("2000");
        data.setAddress("광주광역시");
        data.setCall("01068255567");
        data.setIntroduce("아주 좋은 곳입니다.");

        ViewPager detailPager = (ViewPager)findViewById(R.id.detail_pager);
        DetailFragmentAdapter adapter = new DetailFragmentAdapter(getSupportFragmentManager(), data);
        detailPager.setAdapter(adapter);

        TabLayout detailTab = (TabLayout)findViewById(R.id.detail_tabs);
        detailTab.setupWithViewPager(detailPager);

    }
}
