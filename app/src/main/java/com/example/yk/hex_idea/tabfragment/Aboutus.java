package com.example.yk.hex_idea.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yk.hex_idea.R;

/**
 * Created by Admin on 26-03-2017.
 */

public class Aboutus extends Fragment {
    public static Aboutus newInstances() {
        Aboutus fragment = new Aboutus();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.aboutus,container);
        return rootview;
    }
}
