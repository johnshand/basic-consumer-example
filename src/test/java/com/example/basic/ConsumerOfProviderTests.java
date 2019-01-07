package com.example.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

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

}
