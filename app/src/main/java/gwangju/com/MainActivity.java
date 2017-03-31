package gwangju.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메인버튼 4개. 클릭 시 각각 안내페이지로
        Button themeBtn = (Button) findViewById(R.id.mainBtn1);
        Button zoneBtn = (Button) findViewById(R.id.mainBtn2);
        Button busBtn = (Button) findViewById(R.id.mainBtn3);
        Button boardBtn = (Button) findViewById(R.id.mainBtn4);

        themeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemeSelectActivity.class);
                startActivity(intent);
            }
        });

        zoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ZoneSelectActivity.class);
                startActivity(intent);
            }
        });

        busBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BusSelectActivity.class);
                startActivity(intent);
            }
        });

        boardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
