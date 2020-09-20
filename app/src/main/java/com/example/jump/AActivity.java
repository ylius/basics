package com.example.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.basics.R;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "taskid: " + getTaskId() + ", hash: " + hashCode());
        // Use hash code to see it is a new activity or a reused activity
        logTaskName();

        findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Explicit-1: most commonly used
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "Zhang San");
                bundle.putInt("number", 88);
                intent.putExtras(bundle);
                startActivity(intent);
                // If you start activity from B, it starts a new instance, not return to
                // original A activity.
//                startActivityForResult(intent, 0);


                // Explicit-2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);

                // Explicit-3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this, "com.example.jump.BActivity");
//                startActivity(intent);

                // Explicit-4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.example.jump.BActivity"));
//                startActivity(intent);

                // Implicit
//                Intent intent = new Intent();
//                intent.setAction("com.example.test.BActivity");
//                startActivity(intent);
            }
        });

        findViewById(R.id.btn_jump2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
                // Hash codes are different means these activities are not one same instance.
                // Two instances are created.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("title"), Toast.LENGTH_LONG).show();
    }

    // At singleTop mode, the target activity's onNewIntent() will be called
    // when it is on the top of the stack.
    // At singleTask mode, the target activity's onNewIntent() will be called
    // when it is in the stack, and all the activities above the target activity will be removed.
    // If the target activity is not in the stack, a new instance will be created.
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "----onNewIntent----");
        Log.d("AActivity", "taskid: " + getTaskId() + ", hash: " + hashCode());
        // Use hash code to see it is a new activity or a reused activity
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", info.taskAffinity);
            // info.taskAffinity is the name of the task stack where current activity locates at
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
