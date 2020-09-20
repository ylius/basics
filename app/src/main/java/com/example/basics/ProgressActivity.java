package com.example.basics;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb3;
    private Button mBtnStart;
    private Button mBtnProgressDialog1;
    private Button mBtnProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPb3 = (ProgressBar) findViewById(R.id.pb3);
        mPb3.setProgress(30);
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnProgressDialog1 = (Button) findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2 = (Button) findViewById(R.id.btn_progress_dialog2);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("Notification");
                progressDialog.setMessage("Loading...");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this, "Cancelled");
                    }
                });
                progressDialog.setCancelable(false); // cannot cancel
                // If it is a internet download, after downloaded, call progressDialog.dismiss();
                progressDialog.show();
            }
        });

        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("Notification");
                progressDialog.setMessage("Downloading...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Great", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                progressDialog.show();
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mPb3.getProgress() < 100) {
                handler.postDelayed(runnable, 500); // Delay 500ms to send a message to runnable
            } else {
                ToastUtil.showMsg(ProgressActivity.this, "Loading completed!");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}
