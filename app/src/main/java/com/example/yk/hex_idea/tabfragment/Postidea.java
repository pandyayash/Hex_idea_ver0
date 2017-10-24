package com.example.yk.hex_idea.tabfragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.yk.hex_idea.R;
import com.example.yk.hex_idea.tabfragment.applicationhepler.HttpExecutor;
import com.example.yk.hex_idea.tabfragment.applicationhepler.URLConstatn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Admin on 26-03-2017.
 */

public class Postidea extends Fragment {
    private EditText Ideaname;
    private EditText pislogan1;
    private Spinner spinner;
    private EditText piEditText;
    private Button submitidea;
    List<Spinner_data> spinner_datas;
    int cat_id=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.post_idea,container,false);
        Ideaname=(EditText)rootview.findViewById(R.id.PiEditText1);
        piEditText=(EditText)rootview.findViewById(R.id.PiEditText2);
        pislogan1=(EditText)rootview.findViewById(R.id.pislogan);
        spinner=(Spinner)rootview.findViewById(R.id.spinner);
        submitidea=(Button)rootview.findViewById(R.id.PiButton1);

        SyncHttpClient client = new SyncHttpClient();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
        StrictMode.setThreadPolicy(policy);

        client.post(getActivity(), URLConstatn.GET_IDEA_CAT_URL, null, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsce = new String(responseBody);
                spinner_datas = new Gson().fromJson(responsce, new TypeToken<List<Spinner_data>>(){}.getType());
                Log.e("Size of Bean",spinner_datas.size()+"");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("Responsce on Failer ", "" + statusCode);
            }
        });

        Spinner_Adapter spinner_adapter=new Spinner_Adapter(getActivity(),spinner_datas);
        spinner.setAdapter(spinner_adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  Spinner_data spinner_data= spinner_datas.get(position);
                  cat_id=Integer.valueOf(spinner_data.getCat_id());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitidea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              JSONObject jsonparam=new JSONObject();
                try{
                   jsonparam.put("Idea_Title",Ideaname.getText().toString());
                    jsonparam.put("Idea_slogan",pislogan1.getText().toString());
                    jsonparam.put("cat_id",cat_id);
                    jsonparam.put("Idea_description",piEditText.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                HttpExecutor httpExecutor = new HttpExecutor();
                httpExecutor.httpPost(jsonparam, URLConstatn.POST_IDEA_DATA_URL,getActivity());
            }
        });
        return rootview;
    }
}
