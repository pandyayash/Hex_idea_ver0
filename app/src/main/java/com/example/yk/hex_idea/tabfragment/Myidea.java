package com.example.yk.hex_idea.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yk.hex_idea.R;

import java.util.List;

/**
 * Created by yk on 3/1/2017.
 */

public class Myidea extends Fragment {
    private RecyclerView myrecyclerview;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager mylayoutmanager;
    private List<Myidea_data> mydetails;
    private TextView myidea;

    public static Myidea newInstance() {
        Myidea fragment = new Myidea();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View rootview=inflater.inflate(R.layout.myidea,container,false);
        myidea=(TextView)rootview.findViewById(R.id.textviewmyidea1);

        myrecyclerview=(RecyclerView)rootview.findViewById(R.id.recyclemyidea);
        final Myidea_databeen data=new Myidea_databeen();
        data.initializemyidea();

        mydetails=data.getMyidealist();

        mylayoutmanager=new LinearLayoutManager(getActivity());

        myrecyclerview.setLayoutManager(mylayoutmanager);

        myadapter=new Myidea_Adapter(mydetails,getFragmentManager());

        myrecyclerview.setAdapter(myadapter);


//        myidea.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment=new Postidea();
//                FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.frame_layout,fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });
        return rootview;
    }
}
