package com.example.basics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycle", "----onCreate----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "----onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "----onResume----");
        // Do somenthing like to refresh data every time you enter
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "----onPause----");
        // Do something like to pause movie, game
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "----onStop----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "----onRestart----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "----onDestroy----");
    }
}
