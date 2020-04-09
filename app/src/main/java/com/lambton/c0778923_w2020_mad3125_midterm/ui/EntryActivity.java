package com.lambton.c0778923_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog.Builder;

import android.graphics.Color;
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
import java.util.Date;

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

                                             EntryActivity.this.openDatePicker();
                                         }
                                     });



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedGender = rgGender.getCheckedRadioButtonId();

                String d5 = null;
                int i = 0;
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
                    showAlert("Please Enter First Name");
                } else if (d3.isEmpty()) {
                    showAlert("Please Enter Last name");
                } else if (d4.trim().isEmpty()) {
                    showAlert("Please enter Date of birth");
                }
                else if (checkEligibleDob())
                 {
                 birthDate.setError("Grow up First. Then File Tax");
                 birthDate.setText("Not eligible to file tax for current year 2019".toUpperCase());
                 birthDate.setTextColor(Color.RED);
                 btnCalculate.setVisibility(View.GONE);
                     birthDate.setEnabled(false);
                 }
                else if (d6.trim().isEmpty()) {
                    showAlert("Please Enter Gross Income");
                } else if (d7.trim().isEmpty()) {
                    showAlert("Please Enter RRSP contribution");
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

        public void openDatePicker() {
            Calendar instance = Calendar.getInstance();
            int i = instance.get(Calendar.DAY_OF_MONTH);
            int i2 = instance.get(Calendar.MONTH);
            DatePickerDialog datePickerDialog2 = new DatePickerDialog(this, new OnDateSetListener() {
                public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(i, i2, i3);
                    EntryActivity.this.birthDate.setText(new SimpleDateFormat("dd-MMM-yyyy").format(instance.getTime()).toUpperCase());
                }
            }, instance.get(Calendar.YEAR), i2, i);
            this.datePickerDialog = datePickerDialog2;
            datePickerDialog2.getDatePicker().setMaxDate(new Date().getTime());
            this.datePickerDialog.show();
        }

    public boolean checkEligibleDob() {
        int parseInt = Integer.parseInt(Calculator.getAge(this.birthDate.getText().toString()));
       // StringBuilder sb = new StringBuilder();
       // sb.append("Age: ");
       // sb.append(parseInt);
       // textView.setText(sb.toString());
        if (parseInt < 18) {
            return true;
        }
        return true;
    }

    private void showAlert(String str) {
        Builder builder = new Builder(this);
        builder.setTitle((CharSequence) "Alert!");
        builder.setMessage((CharSequence) str);
        // builder.setIcon((int) C0605R.C0607drawable.ic_action_alert);
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

}



   /* private void initViews() {
        this.txtBirthDate.setInputType(0);
        this.birthLayout = (TextInputLayout) findViewById(C0605R.C0608id.textInputLayout4);
        this.txtAge = (TextView) findViewById(C0605R.C0608id.txtAge);
        this.txtBirthDate.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    DetailEntryActivity.this.closeKeyboard();
                    DetailEntryActivity.this.openDatePicker();
                    return;
                }
                DetailEntryActivity.this.checkEligibleDob();
            }
        });
        this.txtBirthDate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DetailEntryActivity.this.openDatePicker();
            }
        });
        this.btnCalculate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DetailEntryActivity.this.calculateButtonClicked();
            }
        });
    }*/







