package com.example.yk.hex_idea.tabfragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yk.hex_idea.R;
import com.example.yk.hex_idea.tabfragment.applicationhepler.URLConstatn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yk on 3/1/2017.
 */

public class Home extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Home_data> postDataList;
    public static Home newInstance() {
        Home fragment = new Home();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.home,container,false);
        mRecyclerView= (RecyclerView) rootview.findViewById(R.id.employeeRecyclerView);
        final Home_databeen data=new Home_databeen();
        data.initializedata();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
        StrictMode.setThreadPolicy(policy);

        SyncHttpClient client = new SyncHttpClient();

        client.post(getActivity(), URLConstatn.GET_IDEA_DATA_URL, null, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsce = new String(responseBody);
                postDataList = new Gson().fromJson(responsce, new TypeToken<List<Home_data>>(){}.getType());
                Log.e("Size of Bean",postDataList.size()+"");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("Responsce on Failer ", "" + statusCode);
            }
        });


        mLayoutManager=new LinearLayoutManager(getActivity());

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter=new Home_Adapter(postDataList,getFragmentManager());

        mRecyclerView.setAdapter(mAdapter);

        // add a new random card from employees

        return rootview;
    }


}
