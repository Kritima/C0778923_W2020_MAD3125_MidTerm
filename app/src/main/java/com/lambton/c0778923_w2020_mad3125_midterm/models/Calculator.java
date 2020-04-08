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

        public static double performProvinceTax(double d) {
            double d2;
            double d3;
            double d4 = 0.0d;
            if (d > 10582.0d) {
                double d5 = d - 10582.0d;
                if (d5 > 43906.0d) {
                    double d6 = 1682.86d;
                    double d7 = d5 - 33323.99d;
                    if (d7 > 87813.0d) {
                        d6 = 5700.349999999999d;
                        d7 -= 43906.99d;
                        if (d7 > 150000.0d) {
                            d6 = 12640.419999999998d;
                            double d8 = d7 - 62186.99d;
                            if (d8 > 220000.0d) {
                                d4 = 21152.42d;
                                double d9 = d8 - 69999.99d;
                                if (d9 > 220000.01d) {
                                    d4 = 21152.42d + ((d9 * 12.16d) / 100.0d);
                                }
                            } else {
                                d2 = d8 * 12.16d;
                                d4 = d6 + (d2 / 100.0d);
                            }
                        } else {
                            d3 = 11.16d;
                        }
                    } else {
                        d3 = 9.15d;
                    }
                    d2 = d7 * d3;
                    d4 = d6 + (d2 / 100.0d);
                } else {
                    d4 = 0.0d + ((d5 * 5.05d) / 100.0d);
                }
            }
            return ((double) Math.round(d4 * 100.0d)) / 100.0d;
        }

        public static double performFedralTax(double d) {
            double d2;
            double d3 = 0.0d;
            if (d > 12069.0d) {
                double d4 = d - 12069.0d;
                if (d4 > 47630.0d) {
                    double d5 = 5334.0d;
                    double d6 = d4 - 35561.0d;
                    if (d6 > 95259.0d) {
                        d5 = 15097.94d;
                        d6 -= 47628.99d;
                        if (d6 > 147667.0d) {
                            d5 = 28724.02d;
                            d6 -= 52407.99d;
                            if (d6 > 210371.0d) {
                                d3 = 46908.18d;
                                double d7 = d6 - 62703.99d;
                                if (d7 > 210371.01d) {
                                    d3 = 46908.18d + ((d7 * 33.0d) / 100.0d);
                                }
                            } else {
                                d2 = 29.0d;
                            }
                        } else {
                            d2 = 26.0d;
                        }
                    } else {
                        d2 = 20.5d;
                    }
                    d3 = d5 + ((d6 * d2) / 100.0d);
                } else {
                    d3 = 0.0d + ((d4 * 15.0d) / 100.0d);
                }
            }
            return ((double) Math.round(d3 * 100.0d)) / 100.0d;
        }

        public static String getCurrencyFormatted(double d) {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
            currencyInstance.setMinimumFractionDigits(2);
            return currencyInstance.format(d);
        }
    }
}
