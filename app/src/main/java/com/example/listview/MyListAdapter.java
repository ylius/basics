package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.basics.R;

// Adapter tells what each row/grid looks like
public class MyListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    // Do not often use this method.
    @Override
    public Object getItem(int position) {
        return null;
    }

    // Do not often use this method.
    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        ImageView img;
        TextView txtTitle, txtTime, txtContent;
    }

    // getView() means what each row looks like
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.activity_list_view_item, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txt_title);
            holder.txtTime = (TextView) convertView.findViewById(R.id.txt_time);
            holder.txtContent = (TextView) convertView.findViewById(R.id.txt_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtTitle.setText("This is Title " + position);
        holder.txtTime.setText("2088-08-08");
        holder.txtContent.setText("This is new content.");
        Glide.with(mContext).load("https://www.baidu.com/img/bd_logo1.png?qua=high").into(holder.img);
        return convertView;
    }
}
