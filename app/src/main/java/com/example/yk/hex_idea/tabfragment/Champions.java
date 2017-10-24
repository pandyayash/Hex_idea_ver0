package com.example.yk.hex_idea.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yk.hex_idea.R;

import java.util.List;

/**
 * Created by yk on 3/1/2017.
 */

public class Champions extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Employee> mEmployeeList;

    public static Champions newInstance() {
        Champions fragment = new Champions();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.champions, container, false);

        final Employees employees = new Employees();
        employees.initializeData();
        mEmployeeList = employees.getEmployees();
        // connect recycler view
        mRecyclerView = (RecyclerView)rootview.findViewById(R.id.employeeRecyclerView1);
        // create layoutmanager
        mLayoutManager = new LinearLayoutManager(getActivity());
        // set manager to recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        // create adapter
        mAdapter = new EmployeesAdapter(mEmployeeList);
        // set adapter to recycler view
        mRecyclerView.setAdapter(mAdapter);

            return rootview;
        }
    }


