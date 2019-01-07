package com.example.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumerOfProvider {

    private String someString;
    private int someInt;
    private List<String> array;

    public ConsumerOfProvider() {
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
