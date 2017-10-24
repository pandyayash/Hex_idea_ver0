package com.example.yk.hex_idea.tabfragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 21-03-2017.
 */

public class Myidea_databeen {
    private List<Myidea_data> myidealist;

    public void initializemyidea(){
        myidealist=new ArrayList<>();
        myidealist.add(new Myidea_data("hex_IDea","user can shares the idea at company level to describe his/her innovative thinking"));
        myidealist.add(new Myidea_data("hex_IDea","user can shares the idea at company level to describe his/her innovative thinking"));
    }

    public List<Myidea_data> getMyidealist() {
        return myidealist;
    }
}
