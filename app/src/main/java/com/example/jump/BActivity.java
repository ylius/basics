package com.example.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.basics.R;

public class BActivity extends AppCompatActivity {

    private TextView mTxtTitle;
    private Button mBtnFinish, mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.d("BActivity", "----onCreate----");
        Log.d("BActivity", "taskid: " + getTaskId() + ", hash: " + hashCode());
        // Use hash code to see it is a new activity or a reused activity
        logTaskName();

        mTxtTitle = (TextView) findViewById(R.id.txt_title);
        mBtnFinish = (Button) findViewById(R.id.btn_finish);
        mBtn2 = (Button) findViewById(R.id.btn_2);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int number = bundle.getInt("number");
        mTxtTitle.setText(name + ", " + number);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title", "I am back.");
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish(); // Close current page. When current page is destroyed, A activity will show.
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity", "----onNewIntent----");
        Log.d("BActivity", "taskid: " + getTaskId() + ", hash: " + hashCode());
        // Use hash code to see it is a new activity or a reused activity
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity", info.taskAffinity);
            // info.taskAffinity is the name of the task stack where current activity locates at
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
