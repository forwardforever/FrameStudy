package com.bawei.frame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.frame.R;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/3/3 12:59
 */

public class OtherActivity extends Activity {
    private int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        TextView tv_other = (TextView) findViewById(R.id.tv_other);
        tv_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                Intent intent = new Intent();
                intent.putExtra("num",num);
                setResult(100, intent);
                finish();
            }
        });


    }
}
