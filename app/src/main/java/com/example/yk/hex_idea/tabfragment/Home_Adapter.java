package com.example.yk.hex_idea.tabfragment;

import android.content.Context;
import android.os.Bundle;
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
 * Created by yk on 3/17/2017.
 */

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.ViewHolder> {
    private List<Home_data> IDealdatalist;
    Context context;
    FragmentManager fragmentManager;
    public Home_Adapter(List<Home_data> homedatalist, FragmentManager fragmentManager) {
        this.IDealdatalist = homedatalist;
        this.fragmentManager=fragmentManager;
    }
    @Override
    public int getItemCount() {
        return IDealdatalist.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Home_Adapter.ViewHolder holder, int position) {
        Home_data datalist=IDealdatalist.get(position);
        holder.ideaname.setText(datalist.getIdea_Title());
        holder.slogan.setText(datalist.getIdea_slogan());

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView ideaname;
        public TextView slogan;
        public ViewHolder(View itemview){
            super(itemview);
            ideaname=(TextView)itemview.findViewById(R.id.RCTextView1);
            slogan=(TextView)itemview.findViewById(R.id.RCTextView2);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment=new Ideadetails();
                    Bundle bundle=new Bundle();
                    bundle.putString("idea_id",IDealdatalist.get(getAdapterPosition()).getIdea_id());
                    fragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,fragment);
                    fragmentTransaction.commit();

                }
            });

        }

    }


}
