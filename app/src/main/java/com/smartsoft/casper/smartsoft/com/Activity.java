package com.smartsoft.casper.smartsoft.com;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.smartsoft.casper.smartsoft.R;

/**
 * Created by alexander on 09.01.16.
 */
public class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getSupportFragmentManager().getFragments();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFragmentManager().beginTransaction().add(R.id.fr_container, new MainFragment(), "").addToBackStack("d").commit();
        getFragmentManager().beginTransaction().add(R.id.fr_container, new MainFragment(), "").addToBackStack("c").commit();
        getFragmentManager().beginTransaction().add(R.id.fr_container, new MainFragment(), "").addToBackStack("b").commit();
    }
}
