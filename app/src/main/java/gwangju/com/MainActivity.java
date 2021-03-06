package gwangju.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메인버튼 4개. 클릭 시 각각 안내페이지로
        Button omeBtn = (Button) findViewById(R.id.mainBtn1);
        Button zoneBtn = (Button) findViewById(R.id.mainBtn2);
        Button roadBtn = (Button) findViewById(R.id.mainBtn3);
        Button roomsBtn = (Button) findViewById(R.id.mainBtn4);
        Button calBtn = (Button) findViewById(R.id.mainBtn5);
        Button mapBtn = (Button) findViewById(R.id.mainBtn6);

        omeBtn.setOnClickListener(new View.OnClickListener() {
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

        roadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RoadSelectActivity.class);
                startActivity(intent);

            }
        });

        roomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RoomsSelectActivity.class);
                Log.e("넘어간드아아아아아아아","숙소로 넘어간드아아아아아");
                startActivity(intent);
            }
        });

        // 달력 보기
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainMapActivity.class);
                startActivity(intent);
            }
        });

    }
}
