package com.example.administrator.reciver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
    Button Editbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.editTextn);
        ed2=(EditText) findViewById(R.id.editTextp);
        bt=(Button) findViewById(R.id.buttonl);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1.getText().toString().equalsIgnoreCase("surbhi") && ed2.getText().toString().equalsIgnoreCase("surbhi")){
                    Intent i=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(MainActivity.this,"You have entered wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
