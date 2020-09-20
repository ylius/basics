package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basics.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {
//    private List<String> list;

    private Context mContext;
    private OnItemClickListener mListener;

    public GridAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_grid_recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, final int position) {
        holder.txt.setText("Pos " + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "Long clicked Pos " + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30; //list.size()
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView txt;

        public LinearViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
