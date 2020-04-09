package com.lambton.c0778923_w2020_mad3125_midterm;

import java.io.Serializable;

public class DetailList implements Serializable {

    private String name;
    private String value;

    public DetailList(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
