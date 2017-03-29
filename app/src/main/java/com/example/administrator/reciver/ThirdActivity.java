package com.example.administrator.reciver;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 3/25/2017.
 */
public class ThirdActivity extends Activity{
    TextView tv,tv2;
    Button bt;
    EditText et;
    private  Broadcast b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        tv=(TextView) findViewById(R.id.textViewt);
        tv2=(TextView) findViewById(R.id.textViewb);
        bt=(Button) findViewById(R.id.buttonAlarm);
        et=(EditText) findViewById(R.id.editTextAlarm);
        Intent i=getIntent();
       // Bundle b=i.getExtras();
       // String s=b.getString("Text",null);
        String s=i.getStringExtra("Text");

        tv.setText(s);
        b=new Broadcast();
         this.registerReceiver(this.b, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        //Broadcast b=new Broadcast();



       // IntentFilter ifil=new IntentFilter(Intent.ACTION_BATTERY_LOW);

    }
     class Broadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            Log.v("Surbhi",""+level);
            tv2.setText(Integer.toString(level));


        }
    }
    public void satrtAlarm(View v){
        int i=Integer.parseInt(et.getText().toString());
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Time resultdate = new Time(yourmilliseconds);
        //System.out.println(sdf.format(resultdate));
       // java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");
        //Date date1 = null;
        try {
            Date date1 = sdf.parse(sdf.format(resultdate));
            java.util.Date date2 = sdf.parse("i");
            long diff = date2.getTime() - date1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("Surbhi1","catch..." );
        }


        Log.e("Surbhi1","" + (i*1000-System.currentTimeMillis()));
        Log.e("Surbhi2","" + (sdf.format(resultdate)));
        //time = time + (1000*60*60*24)
        Intent ia=new Intent(ThirdActivity.this,MyReceiver.class);
        PendingIntent pi=PendingIntent.getBroadcast(ThirdActivity.this,234324243,ia,0);
        AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
        am.set(am.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pi);
        Toast.makeText(this, "Alarm set in " + i + " seconds",
                Toast.LENGTH_LONG).show();

    }
}
