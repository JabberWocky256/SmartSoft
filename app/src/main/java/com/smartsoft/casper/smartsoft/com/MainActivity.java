package com.smartsoft.casper.smartsoft.com;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.smartsoft.casper.smartsoft.CustomFragmentManager;
import com.smartsoft.casper.smartsoft.R;

/**
 * Created by alexander on 09.01.16.
 */
public class MainActivity extends AppCompatActivity {
    private CustomFragmentManager customFragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getSupportFragmentManager().getFragments();
        MainFragment.count = 0;
    }

    public CustomFragmentManager getCustomFragmentManager() {
        if(customFragmentManager == null) {
            customFragmentManager = new CustomFragmentManager(getFragmentManager());
        }

        return customFragmentManager;
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFragmentManager().beginTransaction().add(R.id.fr_container, new MainFragment(), "tagggggggg").addToBackStack("").commit();
    }
}
