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

        public CRACustomer(String sin, String str2, String str3, String str4, String str5, double d, double d2) {
            this.sin = sin;
            this.fName = str2;
            this.lName = str3;
            this.dob = str4;
            this.gender = str5;
            this.grossIncome = d;
            this.rrspContributed = d2;
        }

        public String getSin() {
            return sin;
        }

        public String fullName() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.lName.toUpperCase());
            sb.append(", ");
            sb.append(this.fName.toLowerCase());
            return sb.toString();
        }

        public String getDob() {
            return this.dob;
        }

        public String getGender() {
            return this.gender;
        }

        public double getGrossIncome() {
            return this.grossIncome;
        }

        public double getRrspContributed() {
            return this.rrspContributed;
        }

        public String getAge() {
            return TaxCalculator.getAge(this.dob);
        }

        public String taxFilingDate() {
            return new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime()).toUpperCase();
        }

        public double getCPP() {
            return TaxCalculator.performCPP(getGrossIncome());
        }

        public double getEI() {
            return TaxCalculator.performEI(getGrossIncome());
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
            return TaxCalculator.performProvinceTax(getTotalTaxableAmount());
        }

        public double getFedralTax() {
            return TaxCalculator.performFedralTax(getTotalTaxableAmount());
        }

        public double getTotalTax() {
            return ((double) Math.round((getProviceTax() + getFedralTax()) * 100.0d)) / 100.0d;
        }

        public double getMaxRRSP() {
            return (this.grossIncome * 18.0d) / 100.0d;
        }
    }


}
