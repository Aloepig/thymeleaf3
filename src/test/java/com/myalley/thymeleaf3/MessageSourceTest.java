package com.myalley.thymeleaf3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void getNameTest(){
        String name = messageSource.getMessage("hello", null, null);
        Assertions.assertEquals("안녕", name);
    }
}
