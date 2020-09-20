package com.example.listview;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.basics.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity2 extends AppCompatActivity {
    private ListView mList;
//    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        mList = (ListView) findViewById(R.id.list2);
/*        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                String jsonResponse = msg.getData().getString("jsonResponse");
                Log.d("MainActivity-Handler", jsonResponse);
                List<Item> items = getItemsFromVividSeats(jsonResponse);
                mList.setAdapter(new ItemAdapter(MainActivity.this, items));
                return false;
            }
        });*/
        new AsyncTask<Void, Void, List<Item>>() {
            @Override
            protected List<Item> doInBackground(Void... params) {
                VividSeatsApi vs = new VividSeatsApi();
                String jsonResponse = null;
                try {
                    jsonResponse = vs.searchForEvents("", "");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.e("AsyncTask", jsonResponse);
                List<Item> items = getItemsFromVividSeats(jsonResponse);
                return items;
            }

            @Override
            protected void onPostExecute(List<Item> items) {
                mList.setAdapter(new MyListAdapter2(ListViewActivity2.this, items));
            }
        }.execute();
    }

    private void initData() {
/*        new Thread(new Runnable() {
            @Override
            public void run() {
                VividSeatsApi vs = new VividSeatsApi();
                String jsonResponse = null;
                try {
                    jsonResponse = vs.searchForEvents();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("MainActivity-SubThread", jsonResponse);
                Message message = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString("jsonResponse", jsonResponse);
                message.setData(bundle);
                mHandler.sendMessage(message);
            }
        }).start();*/
    }

    private List<Item> getItemsFromVividSeats(String jsonResponse) {
        List<Item> items = new ArrayList<>();
        try {
            JSONArray events = new JSONArray(jsonResponse);
            for (int i = 0; i < events.length(); i++) {
                JSONObject event = events.getJSONObject(i);
                if (event != null) {
                    String image = event.getString("image");
                    String title = event.getString("topLabel");
                    String subtitle = event.getString("middleLabel");
                    String description = event.getString("bottomLabel");
                    String count = event.getString("eventCount");
                    Item item = new Item(image, title, subtitle, description, count);
                    items.add(item);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }
}
