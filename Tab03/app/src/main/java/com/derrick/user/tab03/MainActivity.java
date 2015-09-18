package com.derrick.user.tab03;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSetting;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
        setSelect(2);
    }

    private void initEvents() {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_ViewPager);
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);

        mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_img);
        mImgSetting = (ImageButton) findViewById(R.id.id_tab_setting_img);

        mFragments=new ArrayList<Fragment>();
        Fragment mTab01=new WexinFragment();
        Fragment mTab02=new FriendFragment();
        Fragment mTab03=new AddressFragment();
        Fragment mTab04=new SettingFragment();
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mAdapter);

       mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int i, float v, int i1) {

           }

           @Override
           public void onPageSelected(int i) {
                setTag(i);
           }

           @Override
           public void onPageScrollStateChanged(int i) {

           }
       });
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_settings:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    private void setSelect(int i) {
        setTag(i);
        mViewPager.setCurrentItem(i);
    }

    private void setTag(int i) {
        resetImgs();
        switch (i){
            case 0:
                mImgWeixin.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                mImgFrd.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case 2:
                mImgAddress.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case 3:
                mImgSetting.setImageResource(R.mipmap.tab_settings_pressed);
                break;
            default:
                break;
        }
    }

    private void resetImgs() {
        mImgWeixin.setImageResource(R.mipmap.tab_weixin_normal);
        mImgFrd.setImageResource(R.mipmap.tab_find_frd_normal);
        mImgAddress.setImageResource(R.mipmap.tab_address_normal);
        mImgSetting.setImageResource(R.mipmap.tab_settings_normal);
    }
}
