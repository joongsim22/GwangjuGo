package gwangju.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import gwangju.com.list.JavaRoomsDto;

public class SeletedThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleted_theme);

        Intent intent = getIntent();
        String themeTitle = intent.getExtras().getString("themeTitle");

        setTitle(themeTitle);




//        Log.e("######넘어오는값",themeTitle + "");



    }
}
