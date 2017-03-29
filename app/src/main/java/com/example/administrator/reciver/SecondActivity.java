package com.example.administrator.reciver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 3/25/2017.
 */

public class SecondActivity extends Activity{
    EditText ed1;
    Button bt;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        ed1=(EditText) findViewById(R.id.editTextsn);
        bt=(Button) findViewById(R.id.buttonsn);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=ed1.getText().toString();
                Intent i=new Intent(SecondActivity.this,ThirdActivity.class);
               // Bundle b=new Bundle();
                //b.putString("Text",data);
                i.putExtra("Text",data);
                Log.e("Task",data);

               // i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
