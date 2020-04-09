package com.lambton.c0778923_w2020_mad3125_midterm.models;

import com.lambton.c0778923_w2020_mad3125_midterm.utilities.Calculator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CRACustomer implements Serializable {

    private String sin;
    private String fName;
    private String lName;
    private String dob;
    private String gender;
    private double grossIncome;
    private double rrspContributed;

    public String sinKey() {
        return "Person SIN Number";
    }

    public String fullNameKey() {
        return "Full Name";
    }

    public String birthDateKey() {
        return "Birth Of Date";
    }

    public String ageKey() {
        return "Age (Year)";
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

    public String federalKey() {
        return "Federal tax";
    }

    public String genderKey() {
        return "Gender";
    }

    public String grossIncomeKey() {
        return "Gross income";
    }

    public String provinceKey() {
        return "Provincial Tax (Ontario)";
    }

    public String rrspContributedKey() {
        return "RRSP Contributed";
    }

    public String taxFilingDateKey() {
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
        sb.append(fName.substring(0,1).toUpperCase() + fName.substring(1));
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
        return rrspContributed;
    }

    public String getAge() {
        return Calculator.getAge(dob);
    }

    public String taxFilingDate() {
        return new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime()).toUpperCase();
    }

    public double getCPP() {
        return Calculator.calculateCPP(getGrossIncome());
    }

    public double getEI() {
        return Calculator.calculateEI(getGrossIncome());
    }

    public double getRemainingRSSP() {
        return getMaxRRSP() - getRrspContributed();
    }

    public double getTotalTaxableAmount() {
        double cpp = getCPP();
        double ei = getEI();
        double rrspContributed2 = getRrspContributed();
        if (rrspContributed2 > getMaxRRSP()) {
            rrspContributed2 = getMaxRRSP();
        }
        return ((double) Math.round((getGrossIncome() - ((cpp + ei) + rrspContributed2)) * 100.0d)) / 100.0d;
    }

    public double getProviceTax() {
        return Calculator.calculateProvinceTax(getTotalTaxableAmount());
    }

    public double getFedralTax() {
        return Calculator.calculateFedralTax(getTotalTaxableAmount());
    }

    public double getTotalTax() {
        return ((double) Math.round((getProviceTax() + getFedralTax()) * 100.0d)) / 100.0d;
    }

    public double getMaxRRSP() {
        return (this.grossIncome * 18.0d) / 100.0d;
    }


}





