package com.lambton.c0778923_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.lambton.c0778923_w2020_mad3125_midterm.R;
import com.lambton.c0778923_w2020_mad3125_midterm.adapters.DetailAdapter;
import com.lambton.c0778923_w2020_mad3125_midterm.models.CRACustomer;
import com.lambton.c0778923_w2020_mad3125_midterm.models.DetailList;
import com.lambton.c0778923_w2020_mad3125_midterm.utilities.Calculator;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private RecyclerView rvDetailsList;
    private ArrayList<DetailList> detailListArrayList;
    private DetailAdapter detailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        rvDetailsList = findViewById(R.id.recyclerviewDetails);
        populateList();

        detailAdapter = new DetailAdapter(detailListArrayList);
        rvDetailsList.setLayoutManager(new LinearLayoutManager(this));
        rvDetailsList.setAdapter(detailAdapter);

    }

    private void populateList() {
        detailListArrayList = new ArrayList<>();
        Intent i = getIntent();
        CRACustomer c = (CRACustomer) i.getSerializableExtra("sampleObject");

        detailListArrayList.add(new DetailList(c.sinKey(),c.getSin() ));
        detailListArrayList.add(new DetailList(c.fullNameKey(),c.fullName()));
        detailListArrayList.add(new DetailList(c.birthDateKey(),c.getDob()));
        detailListArrayList.add(new DetailList(c.genderKey(),c.getGender()));
        detailListArrayList.add(new DetailList(c.ageKey(),c.getAge()));
        detailListArrayList.add(new DetailList(c.grossIncomeKey(),Calculator.getFormattedCurrency(c.getGrossIncome())));
        detailListArrayList.add(new DetailList(c.federalKey(),Calculator.getFormattedCurrency(c.getFedralTax())));
        detailListArrayList.add(new DetailList(c.provinceKey(),Calculator.getFormattedCurrency(c.getProviceTax())));
        detailListArrayList.add(new DetailList(c.cppKey(), Calculator.getFormattedCurrency((c.getCPP()))));
        detailListArrayList.add(new DetailList(c.eiKey(), Calculator.getFormattedCurrency((c.getEI()))));
        detailListArrayList.add(new DetailList(c.rrspContributedKey(), Calculator.getFormattedCurrency((c.getRrspContributed()))));
        detailListArrayList.add(new DetailList(c.carryRRSPKey(), Calculator.getFormattedCurrency((c.getRemainingRSSP()))));
        detailListArrayList.add(new DetailList(c.totalPayableTaxKey(), Calculator.getFormattedCurrency((c.getTotalTaxableAmount()))));
        detailListArrayList.add(new DetailList(c.totalPaidTaxKey(), Calculator.getFormattedCurrency((c.getTotalTax()))));
    }
}
