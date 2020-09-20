package com.example.basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mImg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mImg4 = (ImageView) findViewById(R.id.img_4);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png?qua=high").into(mImg4);
    }
}
