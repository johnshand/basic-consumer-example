package com.example.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerOfProviderTests {

    @Test
    public void intIsReceived() throws NoSuchFieldException {
        int expectedInt = 2019;

        //given
        final ConsumerOfProvider values = new ConsumerOfProvider();

        //when
        values.setSomeInt(expectedInt);

        //then
        final Field field = values.getClass().getDeclaredField("someInt");
        field.setAccessible(true);
        try {
            assertEquals("Fields didn't match", expectedInt, field.get(values));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringIsReceived() throws NoSuchFieldException {
        String expectedString = "expect me";

        //given
        final ConsumerOfProvider values = new ConsumerOfProvider();

        //when
        values.setSomeString(expectedString);

        //then
        final Field field = values.getClass().getDeclaredField("someString");
        field.setAccessible(true);
        try {
            assertEquals("Fields didn't match", expectedString, field.get(values));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listIsReceived() throws NoSuchFieldException {
        List<String> expectedList = Arrays.asList("This", "Array");

        //given
        final ConsumerOfProvider values = new ConsumerOfProvider();

        //when
        values.setArray(expectedList);

        //then
        final Field field = values.getClass().getDeclaredField("someArray");
        field.setAccessible(true);
        try {
            assertEquals("Fields didn't match", expectedList, field.get(values));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
