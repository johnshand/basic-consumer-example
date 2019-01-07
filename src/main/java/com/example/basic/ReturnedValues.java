package com.example.basic;

import java.util.List;

public class ReturnedValues {
    private String someString;
    private int someInt;
    private List<String> array;

    public ReturnedValues(String someString, int someInt, List<String> array) {
        this.someString = someString;
        this.someInt = someInt;
        this.array = array;
    }

    public String getsomeString() {
        return someString;
    }

    public void setsomeString(String someString) {
        this.someString = someString;
    }

    public int getsomeInt() {
        return someInt;
    }

    public void setsomeInt(int someInt) {
        this.someInt = someInt;
    }

    public List<String> getarray() {
        return array;
    }

    public void setarray(List<String> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "ReturnedValues{" +
                "someString='" + someString + '\'' +
                ", someInt=" + someInt +
                ", array=" + array +
                '}';
    }
}
