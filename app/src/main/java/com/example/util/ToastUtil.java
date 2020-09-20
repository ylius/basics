package com.example.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast mToast;

    // This method will not create multiple Toast, when you click the button at the last time,
    // Toast will disappear after Toast.LENGTH_LONG
    public static void showMsg(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
