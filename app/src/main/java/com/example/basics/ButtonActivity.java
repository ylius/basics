package com.example.basics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn2, btn3;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // Method 2: get Button 2 and pass in an OnClickListener object.
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "You clicked Button 2", Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "You clicked Button 3", Toast.LENGTH_SHORT).show();
            }
        });

        txt = (TextView) findViewById(R.id.txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You clicked Text 1", Toast.LENGTH_SHORT).show();
            }
        });


        // Every View object can be clicked, not only Button object.
        findViewById(R.id.btn_4).setOnClickListener(this);
    }

    // Method 1
    public void button1(View view) {
        // Pop up a message
        Toast.makeText(getApplicationContext(),
                "You clicked Button 1", Toast.LENGTH_SHORT).show();
    }

    // Method 3: Current activity implements OnClickListener interface
    // and override onClick(). Most commonly used, because we often
    // register many click event in one activity.
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),
                "You clicked Button 4", Toast.LENGTH_SHORT).show();
    }
}