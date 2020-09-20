package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.basics.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        mRvGrid = (RecyclerView) findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3)); // 3 items in each row
        mRvGrid.setAdapter(new GridAdapter(this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(GridRecyclerViewActivity.this,
                        "Clicked Pos " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
