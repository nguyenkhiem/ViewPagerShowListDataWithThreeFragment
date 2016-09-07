package com.example.nkhiem.viewpagerloop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    int cur = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.mFragmentAtPos0 = PlusOneFragment.newInstance("khong", 0);
        adapter.mFragmentAtPos1 = PlusOneFragment.newInstance("mot", 1);
        adapter.mFragmentAtPos2 = PlusOneFragment.newInstance("hai", 2);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        cur = 1;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position < cur) {
                    adapter.mFragmentAtPos0 = PlusOneFragment.newInstance("khong", adapter.mFragmentAtPos0.getmParam2() - 1);
                    adapter.mFragmentAtPos1 = PlusOneFragment.newInstance("mot", adapter.mFragmentAtPos1.getmParam2() - 1);
                    adapter.mFragmentAtPos2 = PlusOneFragment.newInstance("hai", adapter.mFragmentAtPos2.getmParam2() - 1);
                } else if (position > cur) {
                    adapter.mFragmentAtPos0 = PlusOneFragment.newInstance("khong", adapter.mFragmentAtPos0.getmParam2() + 1);
                    adapter.mFragmentAtPos1 = PlusOneFragment.newInstance("mot", adapter.mFragmentAtPos1.getmParam2() + 1);
                    adapter.mFragmentAtPos2 = PlusOneFragment.newInstance("hai", adapter.mFragmentAtPos2.getmParam2() + 1);
                }
                adapter.notifyDataSetChanged();
                viewPager.setCurrentItem(1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
