package com.example.simonmcneil.assignment2_simon_mcneil;

import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProvinceSelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Create an arrayList of type Provinces to store province info
    List<Provinces> provinces;

    //Create a listView of type ListView
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province_select);

        listView = (ListView) findViewById(R.id.listView);

        //Calls createList() and method returns the List<Provinces>
        provinces = createList();

        //Hides the ListView until user hits Load Provinces Button
        listView.setVisibility(View.INVISIBLE);

        //Calls adapter Class to display list properties and sends the required properties in the
        //constructor.
        MyAdapter myadapter = new MyAdapter(this,R.layout.list_view_layout, provinces);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String province = provinces.get(position).getProvince();

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("provinceName", province);

        startActivity(intent);
    }

    public void onShowProvinces(View view) {

        listView.setVisibility(View.VISIBLE);
    }

    private List createList()
    {

        provinces = new ArrayList<>();

        Provinces province1 = new Provinces("Alberta","Edmonton", R.drawable.alberta);
        provinces.add(province1);

        Provinces province2 = new Provinces("British Columbia","Victoria", R.drawable.british_columbia);
        provinces.add(province2);

        Provinces province3 = new Provinces("Manitoba","Winnipeg", R.drawable.manitoba);
        provinces.add(province3);

        Provinces province4 = new Provinces("New Brunswick","Fredericton", R.drawable.new_brunswick);
        provinces.add(province4);

        Provinces province5 = new Provinces("Newfoundland and Labrador","St.John's", R.drawable.newfoundland_and_labrador);
        provinces.add(province5);

        Provinces province6 = new Provinces("Nova Scotia","Halifax",R.drawable.nova_scotia);
        provinces.add(province6);

        Provinces province7 = new Provinces("Ontario","Toronto", R.drawable.ontario);
        provinces.add(province7);

        Provinces province8 = new Provinces("Quebec","Quebec", R.drawable.quebec);
        provinces.add(province8);

        Provinces province9 = new Provinces("Saskatchewan","Regina", R.drawable.saskatchewan);
        provinces.add(province9);

        Provinces province10 = new Provinces("Prince Edward ","Charlottetown", R.drawable.prince_edward_island);
        provinces.add(province10);

        return provinces;
    }
}
