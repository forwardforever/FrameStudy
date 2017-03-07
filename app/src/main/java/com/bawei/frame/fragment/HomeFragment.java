package com.bawei.frame.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.frame.R;
import com.bawei.frame.activity.OtherActivity;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/2/22 10:35
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TextView tv_head = (TextView) view.findViewById(R.id.tv_head);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv_head.setText("首页");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OtherActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == 100) {
                String num = data.getStringExtra("num");
                Log.i("xxx", num);
            }

        }
    }
}
