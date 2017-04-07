package gwangju.com;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import gwangju.com.data.GpsInfo;

public class MainMapActivity extends AppCompatActivity{
    Button btnShowLocation;
    EditText editText;

    // GPSTracker class
    GpsInfo gps = null;

    public Handler mHandler;

    public static int RENEW_GPS = 1;
    public static int SEND_PRINT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //

        setContentView(R.layout.activity_main);
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_FINE_LOCATION  },
                    0 );
        }

        editText = (EditText) findViewById(R.id.editText);
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                if(msg.what==RENEW_GPS){
                    makeNewGpsService();
                }
                if(msg.what==SEND_PRINT){
                    logPrint((String)msg.obj);
                }
            }
        };

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // create class object
                if(gps == null) {
                    gps = new GpsInfo(MainMapActivity.this,mHandler);
                }else{
                    gps.Update();
                }

                // check if GPS enabled
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });
    }
    public void makeNewGpsService(){
        if(gps == null) {
            gps = new GpsInfo(MainMapActivity.this,mHandler);
        }else{
            gps.Update();
        }

    }
    public void logPrint(String str){
        editText.append(getTimeStr()+" "+str+"\n");
    }
    public String getTimeStr(){
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("MM/dd HH:mm:ss");
        return sdfNow.format(date);
    }

}
