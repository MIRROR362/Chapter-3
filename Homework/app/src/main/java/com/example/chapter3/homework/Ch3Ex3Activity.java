package com.example.chapter3.homework;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {

    private ViewPager pager;
    private PlaceholderFragment fm_1;
    private SecFragment fm_2;
    private TabLayout tabLayout;
    private List<Fragment> fm_list = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);

        Log.d("ZXR","第一步完成");
        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面

        // TODO: ex3-2, 添加 TabLayout 支持 Tab
        initView();

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),fm_list);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(mFragmentAdapter);
        pager.setCurrentItem(0);
        Log.d("ZXR","第二步完成");

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return fm_list.get(position);
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position){
                Log.d("ZXR","第七步完成");
                if(position==0)
                    return "好友列表";
                else
                    return "我的好友";
            }
        });
        pager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(pager);

    }

    private void initView(){
        tabLayout = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.view_pager);
        fm_1 = new PlaceholderFragment();
        fm_2 = new SecFragment();
        fm_list.add(fm_1);
        fm_list.add(fm_2);
    }

    public class FragmentAdapter extends FragmentPagerAdapter{
        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

}
