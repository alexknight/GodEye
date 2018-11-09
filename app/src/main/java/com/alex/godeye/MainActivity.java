package com.alex.godeye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.alex.godeye.ui.SimpleFragment;
import com.alex.godeye.ui.douban.fragments.DoubanFragment;

public class MainActivity extends AppCompatActivity {


    private TabLayout tablayout;
    private ViewPager viewPager;

    private String[] titles = {"豆瓣电影", "知乎日报", "简书周报", "开发者头条", "知乎日报", "草榴", "美女", "正经新闻",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tablayout.setupWithViewPager(viewPager);

    }


    class PagerAdapter extends FragmentPagerAdapter {

        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (titles[position]){
                case "豆瓣电影":
                    return new DoubanFragment();
                default:
                    SimpleFragment testFragment = new SimpleFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("title", "测试一下");
                    testFragment.setArguments(bundle);
                    return testFragment;
            }
        }

        @Override
        public int getCount() {
            return titles.length;
        }

    }


}
