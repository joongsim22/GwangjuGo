package gwangju.com;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class IntroActivity extends AppCompatActivity {
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ActionBar actionBar  =getActionBar();
        ImageView intro = (ImageView)findViewById(R.id.intro);
        ImageView logo = (ImageView)findViewById(R.id.logo);

        Glide.with(IntroActivity.this).load(R.drawable.introimg).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(intro);

        h = new Handler();
        h.postDelayed(mrun,3000);

    }
    Runnable mrun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(IntroActivity.this, MainActivity.class);

            startActivity(i);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        h.removeCallbacks(mrun);
    }
}
