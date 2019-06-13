package com.example.lacountysouthbaytourguide;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements DoFragment.OnFragmentInteractionListener {

    private static final int ERROR_DIALOG_REQUEST = 9001;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private LinearLayout mainLayout;

    SingleFragmentPageAdapter singleFragmentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        mainLayout = findViewById(R.id.main_layout);

        singleFragmentPageAdapter = new SingleFragmentPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(singleFragmentPageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                    }
                }
                else if(tab.getPosition() == 1){
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.secondPrimary));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.secondaryPrimaryDark));
                    }
                }
                else if(tab.getPosition() == 2){
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.thirdPrimary));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.thirdPrimaryDark));
                    }
                }
                else if(tab.getPosition() == 3){
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.fourthPrimary));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.fourthPrimaryDark));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onFragmentInteraction(Place place) {
        Intent intent = new Intent(MainActivity.this, DetailPageActivity.class);
        intent.putExtra("place", place);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.putExtra("color", getWindow().getStatusBarColor());
        }
        startActivity(intent);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment instanceof DoFragment){
            DoFragment doFragment = (DoFragment)fragment;
            doFragment.setOnFragmentInteractionListener(this);
        }else if(fragment instanceof SeeFragment) {
            SeeFragment seeFragment = (SeeFragment) fragment;
            seeFragment.setOnFragmentInteractionListener(this);
        }else if(fragment instanceof EatFragment) {
            EatFragment eatFragment = (EatFragment) fragment;
            eatFragment.setOnFragmentInteractionListener(this);
        }else if(fragment instanceof ShopFragment) {
            ShopFragment shopFragment = (ShopFragment) fragment;
            shopFragment.setOnFragmentInteractionListener(this);
        }
    }
}
