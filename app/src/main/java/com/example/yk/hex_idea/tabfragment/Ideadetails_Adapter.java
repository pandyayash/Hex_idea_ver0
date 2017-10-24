package com.example.yk.hex_idea.tabfragment;

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


public class Ideadetails_Adapter extends RecyclerView.Adapter<Ideadetails_Adapter.ViewHolder> {
    private List<Home_data> details_list;
    FragmentManager fragmentManager;

    public Ideadetails_Adapter(List<Home_data> details_list,FragmentManager fragmentManager) {
        this.details_list = details_list;
        this.fragmentManager=fragmentManager;
    }

    @Override
    public Ideadetails_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Ideadetails_Adapter.ViewHolder holder, int position) {
        Home_data detailsdatalist=details_list.get(position);
        holder.Ideatitle.setText(detailsdatalist.getIdea_Title());
        holder.Description.setText(detailsdatalist.getIdea_description());
    }

    @Override
    public int getItemCount() {
        return details_list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Ideatitle;
        public TextView Category;
        public TextView Description;

        public ViewHolder(View itemview) {
            super(itemview);
         //  Category=(TextView)itemview.findViewById(R.id.Tcategory);
            Ideatitle = (TextView) itemview.findViewById(R.id.Tideatitle);
            Description = (TextView) itemview.findViewById(R.id.Tideadetails1);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment=new Ideadetails();
                    Bundle bundle=new Bundle();
                    bundle.putString("idea_id",details_list.get(getAdapterPosition()).getIdea_id());
                    fragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,fragment);
                    fragmentTransaction.commit();

                }
            });
        }
    }
}