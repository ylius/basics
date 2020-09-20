package com.example.basics;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTxt4, mTxt5, mTxt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mTxt4 = (TextView) findViewById(R.id.txt_4);
        mTxt4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); // 中划线
        mTxt4.getPaint().setAntiAlias(true); // 去锯齿

        mTxt5 = (TextView) findViewById(R.id.txt_5);
        mTxt5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); // 下划线

        mTxt6 = (TextView) findViewById(R.id.txt_6);
        mTxt6.setText(Html.fromHtml("<u>Terry is speaking.</u>"));
    }
}
