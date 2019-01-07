package com.example.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumerOfProvider {

    private String someString;
    private int someInt;
    private List<String> someArray;

    public ConsumerOfProvider() {
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public List<String> getSomeArray() {
        return someArray;
    }

    public void setArray(List<String> array) {
        this.someArray = array;
    }

    @Override
    public String toString() {
        return "ReturnedValues{" +
                "someString='" + someString + '\'' +
                ", someInt=" + someInt +
                ", someArray=" + someArray +
                '}';
    }
}
