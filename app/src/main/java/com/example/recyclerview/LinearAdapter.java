package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basics.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private List<String> list;

    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewType == 0 ? new LinearViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_linear_recycler_view_item, parent, false))
                : new LinearViewHolder2(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_linear_recycler_view_item_2, parent, false));
    }

    // Use result of this method to set different ViewHolder
    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? 0 : 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == 0) {
            ((LinearViewHolder)holder).txt.setText("Row " + position);
        } else {
            ((LinearViewHolder2)holder).txt.setText("Hello " + position);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "Long clicked Row " + position, Toast.LENGTH_SHORT).show();
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

    class LinearViewHolder2 extends RecyclerView.ViewHolder {
        private TextView txt;
        private ImageView img;

        public LinearViewHolder2(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
