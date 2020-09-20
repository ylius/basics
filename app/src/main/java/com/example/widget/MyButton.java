package com.example.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyButton extends AppCompatButton {
    // All these 3 constructor should be included.
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // A widget's touch event are dispatched from dispatchTouchEvent()
    // dispatchTouchEvent() is an entry method
    // Both ACTION_DOWN and ACTION_UP will call this method
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyButton", "----dispatchTouchEvent----");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "----onTouchEvent----");
                break;
        }
        return super.onTouchEvent(event); // false means this event has been consumed by me, but it can also
        // be consumed by other methods; true means this event has been consumed by me,
        // and it can not be consumed by other methods.
    }
}
