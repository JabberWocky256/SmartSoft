package com.smartsoft.casper.smartsoft.com;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.smartsoft.casper.smartsoft.R;

/**
 * Created by alexander on 09.01.16.
 */
public class MainFragment extends Fragment {
    public static int count = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button view = new Button(getActivity());
        view.setText("MainFragment: " + count);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().attach(new MainFragment()).commit();
            }
        });
        return view;
    }


    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (count < 1) {
            getFragmentManager().beginTransaction().add(R.id.fr_container, new MainFragment(), "").addToBackStack("").commit();
            count++;
        }
    }
}
