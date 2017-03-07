package com.bawei.frame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.frame.R;
import com.bawei.frame.fragment.HomeFragment;
import com.bawei.frame.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    public FragmentTransaction mFragmentTransaction;
    public FragmentManager fragmentManager;
    public String curFragmentTag = "homeFragment";
    private ViewPager vp;
    private List<Fragment> fragments = new ArrayList<>();
    private RadioGroup rg;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        initView();
        initViewPager();

    }


    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        RadioButton rb_home = (RadioButton) findViewById(R.id.rb_home);
        RadioButton rb_me = (RadioButton) findViewById(R.id.rb_me);
        rg.check(R.id.rb_home);
        rg.setOnCheckedChangeListener(this);
    }

    private void initViewPager() {
        //把fragment添加到集合
        homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        MeFragment meFragment = new MeFragment();
        fragments.add(meFragment);
        //创建适配器
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        //设置viewpager监听器
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rg.check(R.id.rb_home);
                } else {
                    rg.check(R.id.rb_me);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                //点击首页按钮选中首页页面
                vp.setCurrentItem(0);
                break;
            case R.id.rb_me:
                //点击我的按钮选中首页页面
                vp.setCurrentItem(1);
                break;
        }
    }

    private class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       /* if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
                String num = data.getStringExtra("num");
                Toast.makeText(MainActivity.this, "num:" + num, Toast.LENGTH_SHORT).show();
                homeFragment.onActivityResult(requestCode, resultCode, data);
            }
        }*/
        /*在这里，我们通过碎片管理器中的Tag，就是每个碎片的名称，来获取对应的fragment*/
        Fragment f = fragmentManager.findFragmentByTag(curFragmentTag);
        /*然后在碎片中调用重写的onActivityResult方法*/
        f.onActivityResult(requestCode, resultCode, data);
    }
}
