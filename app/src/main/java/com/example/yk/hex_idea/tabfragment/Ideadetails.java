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
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Admin on 18-03-2017.
 */

public class Ideadetails extends Fragment{
    private RecyclerView Drecyclerview;
    private RecyclerView.Adapter Dadapter;
    private RecyclerView.LayoutManager Dmanager;
    private List<Home_data> Ddetails;

    public static Ideadetails newInstance() {
        Ideadetails fragment = new Ideadetails();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater onCreateView, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=onCreateView.inflate(R.layout.ideadetails,container,false);
        Drecyclerview=(RecyclerView)rootview.findViewById(R.id.employeeRecyclerView2);
        final Ideadetails_databeen data=new Ideadetails_databeen();
        data.initializedetails();
        String idea_id="";
       // String idea_Title="";
        Bundle bundle= getArguments();
        if(bundle!=null){
            idea_id=bundle.getString("idea_id");
            //   idea_Title=bundle.getString("Idea_Title");
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
        StrictMode.setThreadPolicy(policy);

        JSONObject jasonparam = new JSONObject();
        StringEntity stringEntity = null;
        try {
            jasonparam.put("idea_id",idea_id);
            stringEntity = new StringEntity(jasonparam.toString());
            stringEntity.setContentType("application/json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SyncHttpClient client = new SyncHttpClient();
        client.post(getActivity(), URLConstatn.GET_IDEA_DATAILS_URL, stringEntity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsce = new String(responseBody);
                Ddetails = new Gson().fromJson(responsce, new TypeToken<List<Home_data>>(){}.getType());
                Log.e("Size of Bean",Ddetails.size()+"");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {Log.e("Responsce on Failer ", "" + statusCode);
            }
        });


        Dmanager= new LinearLayoutManager(getActivity());

        Drecyclerview.setLayoutManager(Dmanager);

        Dadapter=new Ideadetails_Adapter(Ddetails,getFragmentManager());

        Drecyclerview.setAdapter(Dadapter);

        return rootview;
    }
}
