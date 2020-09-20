package com.example.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.basics.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharedPreferences, mBtnFile, mBtnExternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreferences = (Button) findViewById(R.id.btn_shared_preferences);
        mBtnFile = (Button) findViewById(R.id.btn_file);
        mBtnExternalFile = (Button) findViewById(R.id.btn_external_file);

        mBtnSharedPreferences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
        mBtnExternalFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_shared_preferences:
                intent = new Intent(this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(this, FileActivity.class);
                break;
            case R.id.btn_external_file:
                intent = new Intent(this, ExternalFileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
