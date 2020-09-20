package com.example.basics;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog; // more pretty than android.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.util.ToastUtil;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.btn_dialog1).setOnClickListener(this);
        findViewById(R.id.btn_dialog2).setOnClickListener(this);
        findViewById(R.id.btn_dialog3).setOnClickListener(this);
        findViewById(R.id.btn_dialog4).setOnClickListener(this);
        findViewById(R.id.btn_dialog5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dialog1:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                builder1.setTitle("Please answer").setMessage("What do you think about this course?")
                        .setIcon(R.drawable.ic_smile)
                        .setPositiveButton("Great", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(DialogActivity.this, "You are honest!");
                            }
                        }).setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(DialogActivity.this, "Try again!");
                    }
                }).setNegativeButton("Bad", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(DialogActivity.this, "Not true!");
                    }
                }).show();
                break;
            case R.id.btn_dialog2:
                final String[] array2 = {"Female", "Male"};
                AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                builder2.setTitle("Choose a gender").setItems(array2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(DialogActivity.this, array2[which]);
                    }
                }).show();
                break;
            case R.id.btn_dialog3:
                final String[] array3 = {"Female", "Male"};
                AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                builder3.setTitle("Choose a gender").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(DialogActivity.this, array3[which]);
                        dialog.dismiss(); // The dialog will disappear if you click a choice
                    }
                }).setCancelable(false).show();
                // setCancelable(false) means the dialog will not disappear
                // if you click somewhere outside the dialog
                break;
            case R.id.btn_dialog4:
                final String[] array4 = {"Sing", "Dance", "Code"};
                boolean[] isSelected = {false, false, true};
                AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                builder4.setTitle("Choose your hobbies").setMultiChoiceItems(array4, isSelected,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                ToastUtil.showMsg(DialogActivity.this, array4[which] + ": " + isChecked);
                            }
                        }).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
            case R.id.btn_dialog5:
                AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);
                EditText etUsername = (EditText) view.findViewById(R.id.et_username);
                EditText etPassword = (EditText) view.findViewById(R.id.et_password);
                Button btnLogin = (Button) view.findViewById(R.id.btn_login);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Use etUsername and etPassword to do sth
                    }
                });
                builder5.setTitle("Please log in").setView(view).show();
                break;
        }
    }
}
