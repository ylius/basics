package com.example.basics;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.anim.ObjectAnimActivity;
import com.example.broadcast.BroadActivity;
import com.example.datastorage.DataStorageActivity;
import com.example.fragment.ContainerActivity;
import com.example.gridview.GridViewActivity;
import com.example.jump.AActivity;
import com.example.listview.ListViewActivity;
import com.example.listview.ListViewActivity2;
import com.example.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.txt_text_view).setOnClickListener(this);
        findViewById(R.id.txt_button).setOnClickListener(this);
        findViewById(R.id.txt_edit_text).setOnClickListener(this);
        findViewById(R.id.txt_radio_button).setOnClickListener(this);
        findViewById(R.id.txt_check_box).setOnClickListener(this);
        findViewById(R.id.txt_image_view).setOnClickListener(this);
        findViewById(R.id.txt_list_view).setOnClickListener(this);
        findViewById(R.id.txt_list_view2).setOnClickListener(this);
        findViewById(R.id.txt_grid_view).setOnClickListener(this);
        findViewById(R.id.txt_recycler_view).setOnClickListener(this);
        findViewById(R.id.txt_web_view).setOnClickListener(this);
        findViewById(R.id.txt_toast).setOnClickListener(this);
        findViewById(R.id.txt_dialog).setOnClickListener(this);
        findViewById(R.id.txt_progress).setOnClickListener(this);
        findViewById(R.id.txt_custom_dialog).setOnClickListener(this);
        findViewById(R.id.txt_popup_window).setOnClickListener(this);
        findViewById(R.id.txt_life_cycle).setOnClickListener(this);
        findViewById(R.id.txt_jump).setOnClickListener(this);
        findViewById(R.id.txt_fragment).setOnClickListener(this);
        findViewById(R.id.txt_event).setOnClickListener(this);
        findViewById(R.id.txt_data).setOnClickListener(this);
        findViewById(R.id.txt_broadcast).setOnClickListener(this);
        findViewById(R.id.txt_anim).setOnClickListener(this);

        // Need to ask for permissions dynamically if compileSdkVersion >= 23
        // 2nd parameter is a String[] includes all permissions requested.
        // Here only request for one permission.
        // 3rd parameter is a request code, you can assign it any number. Later you can use the
        // code to do some processing.
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.txt_text_view:
                intent.setClass(MainActivity.this, TextViewActivity.class);
                break;
            case R.id.txt_button:
                intent.setClass(MainActivity.this, ButtonActivity.class);
                break;
            case R.id.txt_edit_text:
                intent.setClass(this, EditTextActivity.class);
                break;
            case R.id.txt_radio_button:
                intent.setClass(this, RadioButtonActivity.class);
                break;
            case R.id.txt_check_box:
                intent.setClass(this, CheckBoxActivity.class);
                break;
            case R.id.txt_image_view:
                intent.setClass(MainActivity.this, ImageViewActivity.class);
                break;
            case R.id.txt_list_view:
                intent.setClass(MainActivity.this, ListViewActivity.class);
                break;
            case R.id.txt_list_view2:
                intent.setClass(MainActivity.this, ListViewActivity2.class);
                break;
            case R.id.txt_grid_view:
                intent.setClass(this, GridViewActivity.class);
                break;
            case R.id.txt_recycler_view:
                intent.setClass(this, RecyclerViewActivity.class);
                break;
            case R.id.txt_web_view:
                intent.setClass(this, WebViewActivity.class);
                break;
            case R.id.txt_toast:
                intent.setClass(this, ToastActivity.class);
                break;
            case R.id.txt_dialog:
                intent.setClass(this, DialogActivity.class);
                break;
            case R.id.txt_progress:
                intent.setClass(this, ProgressActivity.class);
                break;
            case R.id.txt_custom_dialog:
                intent.setClass(this, CustomDialogActivity.class);
                break;
            case R.id.txt_popup_window:
                intent.setClass(this, PopupWindowActivity.class);
                break;
            case R.id.txt_life_cycle:
                intent.setClass(this, LifeCycleActivity.class);
                break;
            case R.id.txt_jump:
                intent.setClass(this, AActivity.class);
                break;
            case R.id.txt_fragment:
                intent.setClass(this, ContainerActivity.class);
                break;
            case R.id.txt_event:
                intent.setClass(this, EventActivity.class);
                break;
            case R.id.txt_data:
                intent.setClass(this, DataStorageActivity.class);
                break;
            case R.id.txt_broadcast:
                intent.setClass(this, BroadActivity.class);
                break;
            case R.id.txt_anim:
                intent.setClass(this, ObjectAnimActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
