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

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    @Override
    public String toString() {
        return "ReturnedValues{" +
                ", someInt=" + someInt +
                '}';
    }
}
