package com.example.cvapp2.sothich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cvapp2.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class SoThich extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_thich);

        TabLayout tabLayout1 = findViewById(R.id.tabLayout_SoThich);
        TabItem tabHelp1 = findViewById(R.id.tabHelp_SoThich);
        TabItem tabUser1 = findViewById(R.id.tabUser_SoThich);
        ViewPager viewPager1 = findViewById(R.id.viewPager_SoThich);

        PagerAdapter_SoThich pagerAdapter1 = new
                PagerAdapter_SoThich(getSupportFragmentManager(),
                    tabLayout1.getTabCount());
        viewPager1.setAdapter(pagerAdapter1);

        //Change tab view
        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}