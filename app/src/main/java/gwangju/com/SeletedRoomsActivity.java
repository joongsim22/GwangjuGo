package gwangju.com;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gwangju.com.data.JavaRoomsDto;

public class SeletedRoomsActivity extends AppCompatActivity {
    JavaRoomsDto item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleted_rooms);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button btn = (Button)findViewById(R.id.map_btn);
        Intent intent = getIntent();
        item= (JavaRoomsDto) intent.getSerializableExtra("item");
        setTitle(item.getName());

        btn.setText(item.getName());


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeletedRoomsActivity.this, MapActivity.class);
                intent.putExtra("item",item);
                startActivity(intent);
            }
        });


    }
}
