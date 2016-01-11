package com.smartsoft.casper.smartsoft.com;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smartsoft.casper.smartsoft.CustomFragmentManager;

/**
 * Created by alexander on 09.01.16.
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button view = new Button(getActivity());
        view.setText("MainFragment");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomFragmentManager(getFragmentManager()).popBackStackOverlapping();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
