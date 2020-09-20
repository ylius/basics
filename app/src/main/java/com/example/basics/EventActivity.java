package com.example.basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.util.ToastUtil;
import com.example.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent, mBtnHandler;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent = (Button) findViewById(R.id.btn_event);
        mBtnHandler = (Button) findViewById(R.id.btn_handler);
        btnMy = (MyButton) findViewById(R.id.btn_my);
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("OnTouchListener", "----onTouch----");
                        break;
                }
                return false;
            }
        });

        // onClick is caused by the processing of onTouchEvent
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnClickListener", "----onClick----");
            }
        });
        // OnTouchListener's onTouch() will be called earlier than MyButton's onTouchEvent().

        // Method-1: inner class
        mBtnEvent.setOnClickListener(new OnClick());

        // Method-2: anonymous class
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Anonymous class", "Clicked");
                ToastUtil.showMsg(EventActivity.this, "Clicked (anonymous class)");
            }
        });
        // Only last registered listener works. The listener set by onClick attribute in the
        // layout file is considered as the first registered listener.

        // Method-3: EventActivity implements OnClickListener
//        mBtnEvent.setOnClickListener(this);

        // Method-4: outer class
//        mBtnEvent.setOnClickListener(new MyClickListener(this));

        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "Clicked (EventActivity)");
                break;
        }
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event:
                    Log.d("Inner class", "Clicked");
                    ToastUtil.showMsg(EventActivity.this, "Clicked (inner class)");
                    break;
            }
        }
    }
    // Method-5: set onClick attribute in layout file
//    public void show(View view) {
//        switch (view.getId()) {
//            case R.id.btn_event:
//                ToastUtil.showMsg(EventActivity.this, "Clicked (show())");
//                break;
//        }
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "----onTouchEvent----");
                break;
        }
        return false;
    }
}
