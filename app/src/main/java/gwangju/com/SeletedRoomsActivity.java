package gwangju.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SeletedRoomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleted_rooms);

        Intent intent = getIntent();
        String roomsTitle = intent.getExtras().getString("roomsTitle");
        setTitle(roomsTitle);
    }
}
