package com.example.yk.hex_idea.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yk.hex_idea.R;

import java.util.ArrayList;

/**
 * Created by yk on 3/1/2017.
 */

public class Account extends Fragment {
    ArrayList<Account_data> accountdata;

    public static Account newInstance() {
        Account fragment = new Account();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootview=inflater.inflate(R.layout.account,container,false);

        return rootview;
    }
}
