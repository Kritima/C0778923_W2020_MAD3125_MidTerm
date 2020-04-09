package com.lambton.c0778923_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.lambton.c0778923_w2020_mad3125_midterm.models.CRACustomer;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private RecyclerView rvDetailsList;
    private ArrayList<DetailList> detailListArrayList;
    private ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        rvDetailsList = findViewById(R.id.recyclerviewDetails);
        populateList();

        attractionAdapter = new AttractionAdapter(attractions);
        rvCountryList.setLayoutManager(new LinearLayoutManager(this));
        rvCountryList.setAdapter(attractionAdapter);

    }

    private void populateList() {
        detailListArrayList = new ArrayList<>();
        Intent i = getIntent();
        CRACustomer c = (CRACustomer) i.getSerializableExtra("sampleObject");

        detailListArrayList.add(new DetailList("Provider Sin Number",c.getSin() ));
    }
}
