package com.lambton.c0778923_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button submit, clear;
    Spinner suffix;
    TextInputEditText fullname;
    TextInputEditText address;
    TextInputEditText city;
    TextInputEditText province;
    TextInputEditText postalCode;
    TextInputEditText email;
    TextInputEditText phone;
    TextInputEditText area;
    TextInputEditText description;
    TextInputEditText date;
    Spinner designation;
    RadioGroup status;
    RadioButton radiobutton1;
    RadioButton radiobutton2;
    RadioButton radiobutton3;
    CheckBox networkProblem, systemCrashing, slowInternet, softwareInstallation;
    DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        suffix = (Spinner) findViewById(R.id.spinner);
        severity = (RatingBar) findViewById(R.id.rbFeedback);
        submit = (Button) findViewById(R.id.btnSubmit);
        clear = (Button) findViewById(R.id.btnClear);
        fullname = (TextInputEditText) findViewById(R.id.NameTextInputEditText);
        status = (RadioGroup) findViewById(R.id.radioGroup);
        address = (TextInputEditText) findViewById(R.id.AddressTextInputEditText);
        city = (TextInputEditText) findViewById(R.id.CityTextInputEditText);
        province = (TextInputEditText) findViewById(R.id.ProvinceTextInputEditText);
        postalCode = (TextInputEditText) findViewById(R.id.PostalCodeTextInputEditText);
        email = (TextInputEditText) findViewById(R.id.EmailTextInputEditText);
        phone = (TextInputEditText) findViewById(R.id.PhoneTextInputEditText);
        area = (TextInputEditText) findViewById(R.id.AreaTextInputEditText);
        description = (TextInputEditText) findViewById(R.id.DescriptionTextInputEditText);
        date = (TextInputEditText) findViewById(R.id.DateTextInputEditText);
        designation = (Spinner) findViewById(R.id.spinner2);
        radiobutton1 = (RadioButton) findViewById(R.id.radioButton);
        radiobutton2 = (RadioButton) findViewById(R.id.radioButton2);
        radiobutton3 = (RadioButton) findViewById(R.id.radioButton3);
        networkProblem = (CheckBox) findViewById(R.id.networkProblem);
        systemCrashing = (CheckBox) findViewById(R.id.systemCrashing);
        slowInternet = (CheckBox) findViewById(R.id.slowInternet);
        softwareInstallation = (CheckBox) findViewById(R.id.softwareInstallation);


        severity.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(final RatingBar ratingBar, final float rating, final boolean fromUser) {
                setCurrentRating(rating);
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        FirstActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date1 = month + "/" + day + "/" + year;
                date.setText(date1);
            }
        };

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = status.getCheckedRadioButtonId();

                int n = 0;
                int i = 0;
                if (selectedId == R.id.radioButton) {
                    n = 1;
                } else if (selectedId == R.id.radioButton2) {
                    n = 2;
                } else if (selectedId == R.id.radioButton3) {
                    n = 3;
                }


                Complaint c = new Complaint(suffix.getSelectedItem().toString(), fullname.getText().toString(), n, designation.getSelectedItem().toString(),
                        address.getText().toString(),
                        province.getText().toString(), city.getText().toString(), postalCode.getText().toString(), email.getText().toString(),
                        area.getText().toString(), phone.getText().toString(), date.getText().toString(), getIssues(), description.getText().toString(), severity.getRating());
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("sampleObject", c);
                startActivity(intent);

            }


        });

    }

    private void setCurrentRating(float rating) {
        LayerDrawable stars = (LayerDrawable)severity.getProgressDrawable();
        switch (Math.round(rating)) {
            case 1:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.cyan), PorterDuff.Mode.SRC_ATOP);
                break;
            case 2:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.SRC_ATOP);
                break;
            case 3:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);
                break;
            case 4:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
                break;
            case 5:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
                break;
        }

    }

    private ArrayList<String> getIssues(){
        ArrayList<String> issueList= new ArrayList<>();
        if(networkProblem.isChecked()){
            issueList.add("Network Problem");
        }
        if(systemCrashing.isChecked()){
            issueList.add("System Crashing");
        }
        if(slowInternet.isChecked()){
            issueList.add("Slow Internet");
        }
        if(softwareInstallation.isChecked()){
            issueList.add("Software Installation");
        }
        return issueList;
    }
}