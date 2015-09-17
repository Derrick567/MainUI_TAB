package com.derrick.user.tab01;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews=new ArrayList<View>();

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg ;
    private ImageButton mFrdImg ;
    private ImageButton mAddressImg ;
    private ImageButton mSettingImg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        initView();
        initEvents();

    }

    private void initEvents() {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                resetImg();
            int currentItem =mViewPager.getCurrentItem();
                switch (currentItem){
                    case 0:
                        mWeixinImg.setImageResource(R.mipmap.tab_weixin_pressed);
                    break;
                    case 1:
                        mFrdImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                        break;
                    case 2:
                        mAddressImg.setImageResource(R.mipmap.tab_address_pressed);
                        break;
                    case 3:
                        mSettingImg.setImageResource(R.mipmap.tab_settings_pressed);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mViewPager =(ViewPager)findViewById(R.id.viewPager);

        mTabWeixin= (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd= (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress= (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting= (LinearLayout) findViewById(R.id.id_tab_settings);

        mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddressImg= (ImageButton) findViewById(R.id.id_tab_address_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_setting_img);

        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View tab01=mLayoutInflater.inflate(R.layout.tab01, null);
        View tab02=mLayoutInflater.inflate(R.layout.tab02,null);
        View tab03=mLayoutInflater.inflate(R.layout.tab03,null);
        View tab04=mLayoutInflater.inflate(R.layout.tab04,null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        mPagerAdapter=new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
               View view =  mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        };

        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        //switch every images to dark color;
        resetImg();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                mFrdImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImg.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(3);
                mSettingImg.setImageResource(R.mipmap.tab_settings_pressed);
                break;
            default:
                break;
        }
    }

    private void resetImg() {
        mWeixinImg.setImageResource(R.mipmap.tab_weixin_normal);
        mFrdImg.setImageResource(R.mipmap.tab_find_frd_normal);
        mAddressImg.setImageResource(R.mipmap.tab_address_normal);
        mSettingImg.setImageResource(R.mipmap.tab_settings_normal);
    }
}
