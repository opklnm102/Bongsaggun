package io.j2ffrey_2.bongsaggun;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.toolbar_title) TextView tvTitle;
    @Bind(R.id.drawer) DrawerLayout mDrawerLayout;
    @Bind(R.id.nav_view) NavigationView nV;
    ActionBarDrawerToggle toogle;
    @Bind(R.id.tabs) TabLayout mTabLayout;
    @Bind(R.id.viewPager) ViewPager mViewPager;
    PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setHomeAsUpIndicator(R.drawable.ic_drawer);
//            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayShowHomeEnabled(true);
        }

        if(nV != null){
            setUpDrawerContent(nV);
        }

        toogle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        toogle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(toogle);

        if(mViewPager != null){
            setUpViewPager(mViewPager);
        }
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpDrawerContent(NavigationView navigationView){

    }

    private void setUpViewPager(ViewPager viewPager){
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new HomeFragment(), "홈");
        mPagerAdapter.addFragment(new CalendarFragment(), "캘린더");
        mPagerAdapter.addFragment(new ZzimFragment(), "찜");
        mPagerAdapter.addFragment(new MyPageFragment(), "마이페이지");
        viewPager.setAdapter(mPagerAdapter);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }

    static class PagerAdapter extends FragmentPagerAdapter{
        private final ArrayList<Fragment> mFragments = new ArrayList<>();
        private final ArrayList<String> mFragmentTitles = new ArrayList<>();

        public PagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addFragment(Fragment fragment, String title){
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
