package com.example.yk.hex_idea.tabfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yk.hex_idea.R;

import java.util.List;


/**
 * Created by Admin on 01-04-2017.
 */

public class Spinner_Adapter extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    List<Spinner_data> spinner_datas;

    public Spinner_Adapter(Context applicationContext, List<Spinner_data> spinner_datas) {
        this.context = applicationContext;
        this.spinner_datas = spinner_datas;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return spinner_datas.size();
    }

    @Override
    public Object getItem(int i) {
        return spinner_datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return spinner_datas.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_item, null);
        TextView names = (TextView) view.findViewById(R.id.twspinner1);
        Spinner_data spinner_data=spinner_datas.get(i);
        names.setText(spinner_data.getC_name());
        return view;
    }
}
