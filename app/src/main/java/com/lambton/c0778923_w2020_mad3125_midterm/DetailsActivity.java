package com.lambton.c0778923_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lambton.c0778923_w2020_mad3125_midterm.models.CRACustomer;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();
        CRACustomer c = (CRACustomer) i.getSerializableExtra("sampleObject");

    }
}
