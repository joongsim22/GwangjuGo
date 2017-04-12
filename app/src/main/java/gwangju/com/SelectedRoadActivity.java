package gwangju.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import gwangju.com.data.dto.OmeGwangjuRoadDto;

public class SelectedRoadActivity extends AppCompatActivity {
    List<OmeGwangjuRoadDto> list;
    OmeGwangjuRoadDto item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_road);
        Intent intent = getIntent();

        String themeTitle = intent.getExtras().getString("item");
        setTitle(themeTitle);


    }
}
