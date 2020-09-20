package com.example.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.basics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    private TextView mTxtTitle;
    //    private Activity mActivity;
    private Button mBtnChange, mBtnReset, mBtnMessage;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public AFragment() {
        // Required empty public constructor
    }

    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public interface IOnMessageClick {
        void onClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        mActivity = (Activity) context; // Not suggest
        try {
            listener = (IOnMessageClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement interface IOnMessageClick");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("AFragment", "----onCreateView----");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTxtTitle = (TextView) view.findViewById(R.id.txt_title);
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnReset = (Button) view.findViewById(R.id.btn_reset);
        mBtnMessage = (Button) view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity) getActivity()).setData("Hi"); // Not recommend
                listener.onClick("Hey");
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment)
                            .add(R.id.fl_container, bFragment)
                            .addToBackStack(null).commitAllowingStateLoss();
                    // This method will keep the changed TextView content of AFragment
                    // when you return to AFragment from BFragment
                    // replace() will not keep the last view of AFragment, although AFragment is
                    // not recreated, but its view is recreated.
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment)
                            .addToBackStack(null).commitAllowingStateLoss();
                }
                // By using addToBackStack(null), we can return to last fragment when
                // we press return button on the phone, not quit current activity.
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxtTitle.setText("I am a new character");
            }
        });
        // You can use mActivity here, but try not to use mActivity because memory leak may happen.
        // Suggest using check if getActivity() != null so that crash will not happen
//        if (getActivity() != null) {
//            // TODO
//        } else {
//
//        }
        if (getArguments() != null) {
            mTxtTitle.setText(getArguments().getString("title"));
        }
    }


    // If getActivity() == null, this fragment must call onDetach() before.

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Cancel asynchronization: if the activity does not exist, any tasks that the fragment does
        // are useless, because when the fragment has finished the tasks, it needs to call
        // getActivity() but getActivity() is null, so we can cancel the tasks in onDestroy().
        // If the tasks cannot be cancelled, we use getActivity() to check if the activity is null
        // after the tasks are finished.
    }
}
