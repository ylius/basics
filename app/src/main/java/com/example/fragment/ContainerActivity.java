package com.example.fragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.basics.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private Fragment aFragment;
//    private Fragment bFragment;
//    private Button mBtnChange;
    private TextView mTxtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTxtTitle = (TextView) findViewById(R.id.txt_title);
//        mBtnChange = (Button) findViewById(R.id.btn_change);
//        mBtnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (bFragment == null) {
//                    bFragment = new BFragment();
//                }
//                getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment)
//                        .commitAllowingStateLoss();
//            }
//        });

        // Instantiate AFragment
        // aFragment = new AFragment();
        aFragment = AFragment.newInstance("I am a parameter");
        // Add AFragment in activity, remember to commit
        getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a")
                .commitAllowingStateLoss(); // a is tag
        // Using commit() here may return some errors, such as switching between portrait and
        // landscape orientation.
    }

    // Not recommend
    public void setData(String text) {
        mTxtTitle.setText(text);
    }

    @Override
    public void onClick(String text) {
        mTxtTitle.setText(text);
    }
}
