package com.example.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.basics.R;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        tvTest = (TextView) findViewById(R.id.tv_test);

//        tvTest.animate().translationYBy(500).setDuration(2000).start();
//        become transparent in 2s
//        tvTest.animate().alpha(0).setDuration(2000).start();

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
////                valueAnimator实际的值
//                Log.d("aaaa", animation.getAnimatedValue() + "");
////                动画的进度0-1
//                Log.d("aaaa", animation.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest, "translationY", 0, 500, 200, 800);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}