package com.example.simonmcneil.assignment2_simon_mcneil;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by simonmcneil on 2016-11-11.
 */

public class MyAdapter extends ArrayAdapter<Provinces> {

    List myList = new ArrayList<>();

    //creating constructor for MyAdapter
    public MyAdapter(Context context, int resource, List objects){
        super(context, resource, objects);

        //gets the Provinces List from ProvinceSelectActivity class
        myList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;

        //Checks if current view is empty
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_view_layout, null);
        }


        TextView provinceTv = (TextView) v.findViewById(R.id.provinceTv);
        TextView cityTv = (TextView) v.findViewById(R.id.cityTv);
        ImageView flagIm = (ImageView) v.findViewById(R.id.imageViewFlag);


        //gets the current position in the ArrayList of provinces and displays its information
        //This method continuously increments until the last position of the ArrayList of type provinces
        Provinces provinceInfo = (Provinces) myList.get(position);

        //Sets Province
        provinceTv.setText(provinceInfo.getProvince());

        //Sets City
        cityTv.setText(provinceInfo.getCapital());

        //Sets Flag
        flagIm.setBackgroundResource(provinceInfo.getFlag());

        return v;

        }

    }
