package com.example.yk.hex_idea.tabfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yk.hex_idea.R;

import java.util.List;

/**
 * Created by Admin on 21-03-2017.
 */

public class Myidea_Adapter extends RecyclerView.Adapter<Myidea_Adapter.ViewHolder> {

    private List<Myidea_data> myidea_data_List;
    FragmentManager fragmentManager;

    public Myidea_Adapter(List<Myidea_data> myidea_data_List, FragmentManager fragmentManager) {
        this.myidea_data_List = myidea_data_List;
        this.fragmentManager= fragmentManager;
    }

    @Override
    public Myidea_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item3,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Myidea_Adapter.ViewHolder holder, int position) {
        Myidea_data myideaDatalist=myidea_data_List.get(position);
        holder.Ideatitle.setText(myideaDatalist.title);
        holder.Description.setText("ff");
    }

    @Override
    public int getItemCount() {
        return myidea_data_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView Ideatitle;
            public TextView Description;

            public ViewHolder(View itemview) {
                super(itemview);
                this.Ideatitle = (TextView) itemview.findViewById(R.id.Tmyideatitle);
                this.Description = (TextView) itemview.findViewById(R.id.RCTextView2);

                 itemview.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Fragment fragment=new Ideadetails();
                     FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.frame_layout,fragment);
                     fragmentTransaction.commit();
                 }
             });

            }
    }
}
