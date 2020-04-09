package com.lambton.c0778923_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.lambton.c0778923_w2020_mad3125_midterm.R;
import com.lambton.c0778923_w2020_mad3125_midterm.models.CRACustomer;
import com.lambton.c0778923_w2020_mad3125_midterm.utilities.Calculator;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EntryActivity extends AppCompatActivity {

    Button btnCalculate;
    TextInputEditText firstName, lastName, sin, birthDate, grossIncome, rrspContribution;
    TextInputLayout sinLayout;
    RadioGroup rgGender;
    RadioButton rbMale;
    RadioButton rbFemale;
    RadioButton rbOther;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sin = (TextInputEditText) findViewById(R.id.sinTextInputEditText);
        sinLayout = (TextInputLayout) findViewById(R.id.sinTextInputLayout);
        firstName = (TextInputEditText) findViewById(R.id.firstNameTextInputEditText);
        lastName = (TextInputEditText) findViewById(R.id.lastNameTextInputEditText);
        birthDate = (TextInputEditText) findViewById(R.id.birthDateTextInputEditText);
        grossIncome = (TextInputEditText) findViewById(R.id.grossIncomeTextInputEditText);
        rrspContribution = (TextInputEditText) findViewById(R.id.rrspContributedTextInputEditText);
        rgGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        rbMale = (RadioButton) findViewById(R.id.radioButtonMale);
        rbFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        rbOther = (RadioButton) findViewById(R.id.radioButtonOther);
        btnCalculate = (Button) findViewById(R.id.btnSubmit);


        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EntryActivity.this,
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
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, day);
                birthDate.setText(new SimpleDateFormat("dd-MMM-yyyy").format(cal.getTime()).toUpperCase());
            }
        };


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedGender = rgGender.getCheckedRadioButtonId();

                String d5 = null;
                if (selectedGender == R.id.radioButtonMale) {
                    d5 = "Male";
                } else if (selectedGender == R.id.radioButtonFemale) {
                    d5 = "Female";
                } else if (selectedGender == R.id.radioButtonOther) {
                    d5 = "Other";
                }


                String d1 = sin.getText().toString();
                String d2 = firstName.getText().toString();
                String d3 = lastName.getText().toString();
                String d4 = birthDate.getText().toString();
                String d6 = grossIncome.getText().toString();
                String d7 = rrspContribution.getText().toString();

                if (d1.length() != 9) {
                    sin.setError("SIN Should be of 9 digits.");
                } else if (d2.isEmpty()) {
                    firstName.setError("Please Enter First Name");
                } else if (d3.isEmpty()) {
                    lastName.setError("Please Enter Last name");
                } else if (d4.trim().isEmpty()) {
                    birthDate.setError("Please enter Date of Birth");
                } else if (checkEligibleBirthDate()) {
                    birthDate.setError("");
                    birthDate.setText("Not eligible to file tax for current year 2019".toUpperCase());
                    birthDate.setTextColor(Color.RED);
                    disableFields();
                } else if (d6.trim().isEmpty()) {
                    grossIncome.setError("Please Enter Gross Income");
                } else if (d7.trim().isEmpty()) {
                    rrspContribution.setError("Please Enter RRSP contribution");
                } else {
                    CRACustomer craCustomer = new CRACustomer(d1, d2, d3, d4, d5,
                            Double.parseDouble(d6), Double.parseDouble(d7));
                    Intent intent = new Intent(EntryActivity.this, DetailsActivity.class);
                    intent.putExtra("details", craCustomer);
                    startActivity(intent);

                }
            }

        });

    }

    public boolean checkEligibleBirthDate() {
        int parseInt = Integer.parseInt(Calculator.getAge(this.birthDate.getText().toString()));
        if (parseInt < 18) {
            return true;
        }
        return false;
    }

    private void disableFields() {
        btnCalculate.setVisibility(View.GONE);
        sin.setEnabled(false);
        firstName.setEnabled(false);
        lastName.setEnabled(false);
        birthDate.setEnabled(false);
        rgGender.setEnabled(false);
        rbFemale.setEnabled(false);
        rbMale.setEnabled(false);
        rbOther.setEnabled(false);
        grossIncome.setEnabled(false);
        rrspContribution.setEnabled(false);
    }


}








