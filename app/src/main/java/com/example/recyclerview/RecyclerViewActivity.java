package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.basics.R;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        findViewById(R.id.btn_linear).setOnClickListener(this);
        findViewById(R.id.btn_hor).setOnClickListener(this);
        findViewById(R.id.btn_grid).setOnClickListener(this);
        findViewById(R.id.btn_staggered_grid).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()) {
            case R.id.btn_linear:
                intent = new Intent(this, LinearRecyclerViewActivity.class);
                break;
            case R.id.btn_hor:
                intent = new Intent(this, HorRecyclerViewActivity.class);
                break;
            case R.id.btn_grid:
                intent = new Intent(this, GridRecyclerViewActivity.class);
                break;
            case R.id.btn_staggered_grid:
                intent = new Intent(this, StaggeredGridRecyclerViewActivity.class);
                break;
        }
        startActivity(intent);
    }
}
