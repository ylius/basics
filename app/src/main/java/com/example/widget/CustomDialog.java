package com.example.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.basics.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTxtTitle, mTxtMessage, mTxtCancel, mTxtConfirm;
    private String title, message, cancel, confirm;

    private IOnCancelListener cancelListener;

    private IOnConfirmListener confirmListener;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //Set width
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8); // set dialog width is 80% of screen width
        getWindow().setAttributes(p);

        mTxtTitle = (TextView) findViewById(R.id.txt_title);
        mTxtMessage = (TextView) findViewById(R.id.txt_message);
        mTxtCancel = (TextView) findViewById(R.id.txt_cancel);
        mTxtConfirm = (TextView) findViewById(R.id.txt_confirm);
        if (!TextUtils.isEmpty(title)) {
            mTxtTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTxtMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTxtCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTxtConfirm.setText(confirm);
        }
        mTxtCancel.setOnClickListener(this);
        mTxtConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.txt_confirm:
                if (confirmListener != null) {
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }
}
