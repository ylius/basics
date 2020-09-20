package com.example.basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mChk1, mChk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mChk1 = (CheckBox) findViewById(R.id.chk_1);
        mChk2 = (CheckBox) findViewById(R.id.chk_2);

        mChk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ?
                        "Checked Programming" : "Unchecked Programming", Toast.LENGTH_SHORT).show();
            }
        });
        mChk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ?
                        "Checked Cooking" : "Unchecked Cooking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
