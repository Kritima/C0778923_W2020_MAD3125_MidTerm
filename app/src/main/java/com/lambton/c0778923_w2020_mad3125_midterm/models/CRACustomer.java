package com.lambton.c0778923_w2020_mad3125_midterm.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CRACustomer {

    private String sin;
    private String fName;
    private String lName;
    private String dob;
    private String gender;
    private double grossIncome;
    private double rrspContributed;

    public String ageKey() {
        return "Age (Year)";
    }

    public String birthDateKey() {
        return "Birth Of Date";
    }

    public String carryRRSPKey() {
        return "Carry forward RRSP";
    }

    public String cppKey() {
        return "CPP";
    }

    public String eiKey() {
        return "EI";
    }

    public String fedralKey() {
        return "Federal tax";
    }

    public String fullNameKey() {
        return "Full Name";
    }

    public String genderKey() {
        return "Gender";
    }

    public String incomeKey() {
        return "Gross income";
    }

    public String provinceKey() {
        return "Provincial Tax (Ontario)";
    }

    public String rrspContributedKey() {
        return "RRSP Contributed";
    }

    public String sinKey() {
        return "Person SIN Number";
    }

    public String taxDateKey() {
        return "Tax Filing date";
    }

    public String totalPaidTaxKey() {
        return "Total Tax Payed";
    }

    public String totalPayableTaxKey() {
        return "Total Taxable Income";
    }

    public CRACustomer(String sin, String fName, String lName, String dob, String gender, double grossIncome, double rrspContributed) {
        this.sin = sin;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
    }

    public String getSin() {
        return sin;
    }

    public String fullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(lName.toUpperCase());
        sb.append(", ");
        sb.append(fName.toLowerCase());
        return sb.toString();
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public double getRrspContributed() {
        return this.rrspContributed;
    }

    



}





