package com.example.recyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.basics.R;

public class StaggeredGridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvStaggeredGird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_recycler_view);

        mRvStaggeredGird = (RecyclerView) findViewById(R.id.rv_staggered_grid);
        mRvStaggeredGird.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)); // 2 cols; 2 rows when HORIZONTAL
        mRvStaggeredGird.addItemDecoration(new MyDecotation());
        mRvStaggeredGird.setAdapter(new StaggeredGridAdapter(this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(StaggeredGridRecyclerViewActivity.this,
                        "Clicked Pos " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecotation extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelSize(R.dimen.dividerHeight2);
            outRect.set(gap, gap, gap, gap);
        }
    }
}
