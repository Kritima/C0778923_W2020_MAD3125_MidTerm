package com.lambton.c0778923_w2020_mad3125_midterm.models;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Calculator {

        private static final double DEFAULT_CPP_AMOUNT = 2927.4d;
        private static final double DEFAULT_EI_AMOUNT = 860.22d;
        private static final double MAX_CPP_AMOUNT = 57400.0d;
        private static final double MAX_EI_AMOUNT = 53100.0d;

        public static double calculateCPP(double a) {
            if (a > MAX_CPP_AMOUNT) {
                return DEFAULT_CPP_AMOUNT;
            }
            else
            {

                 return (a * 5.1d) / 100.0d;
            }
        }

        private Calculator() {
        }

        public static String getAge(String str) {
            Date date;
            try {
                date = new SimpleDateFormat("dd-MMM-yyyy").parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
                date = null;
            }
            if (date == null) {
                return "0";
            }
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance.setTime(date);
            return String.valueOf(instance2.get(1) - instance.get(1));
        }

        public static double calculateEI(double a) {
            if (a > MAX_EI_AMOUNT) {
                return DEFAULT_EI_AMOUNT;
            } else {

                return ((double) Math.round(((a * 1.62d) / 100.0d) * 100.0d)) / 100.0d;
            }
        }

        public static double calculateProvinceTax(double a) {
            double a2;
            double a3;
            double a4 = 0.0d;
            if (a > 10582.0d)
            {
                double a5 = a - 10582.0d;
                if (a5 > 43906.0d)
                {
                    double a6 = 1682.86d;
                    double a7 = a5 - 33323.99d;
                    if (a7 > 87813.0d)
                    {
                        a6 = 5700.349999999999d;
                        a7 -= 43906.99d;
                        if (a7 > 150000.0d)
                        {
                            a6 = 12640.419999999998d;
                            double a8 = a7 - 62186.99d;
                            if (a8 > 220000.0d)
                            {
                                a4 = 21152.42d;
                                double a9 = a8 - 69999.99d;
                                if (a9 > 220000.01d)
                                {
                                    a4 = 21152.42d + ((a9 * 12.16d) / 100.0d);
                                }
                            }
                            else
                                {
                                a2 = a8 * 12.16d;
                                a4 = a6 + (a2 / 100.0d);
                            }
                        }
                        else
                            {
                            a3 = 11.16d;
                        }
                    }
                    else
                        {
                        a3 = 9.15d;
                    }
                    a2 = a7 * a3;
                    a4 = a6 + (a2 / 100.0d);
                }
                else
                    {
                    a4 = 0.0d + ((a5 * 5.05d) / 100.0d);
                }
            }
            return ((double) Math.round(a4 * 100.0d)) / 100.0d;
        }

        public static double calculateFedralTax(double a) {
            double a2;
            double a3 = 0.0d;
            if (a > 12069.0d)
            {
                double a4 = a - 12069.0d;
                if (a4 > 47630.0d)
                {
                    double a5 = 5334.0d;
                    double a6 = a4 - 35561.0d;
                    if (a6 > 95259.0d)
                    {
                        a5 = 15097.94d;
                        a6 -= 47628.99d;

                        if (a6 > 147667.0d)
                        {
                            a5 = 28724.02d;
                            a6 -= 52407.99d;
                            if (a6 > 210371.0d)
                            {
                                a3 = 46908.18d;
                                double a7 = a6 - 62703.99d;

                                if (a7 > 210371.01d)
                                {
                                    a3 = 46908.18d + ((a7 * 33.0d) / 100.0d);
                                }
                            }
                            else
                                {
                                a2 = 29.0d;
                            }
                        }
                        else
                            {
                            a2 = 26.0d;
                        }
                    }
                    else
                        {
                        a2 = 20.5d;
                    }
                    a3 = a5 + ((a6 * a2) / 100.0d);
                }
                else
                    {
                    a3 = 0.0d + ((a4 * 15.0d) / 100.0d);
                }
            }
            return ((double) Math.round(a3 * 100.0d)) / 100.0d;
        }

        public static String getFormattedCurrency(double c) {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
            currencyInstance.setMinimumFractionDigits(2);
            return currencyInstance.format(c);
        }
    }
