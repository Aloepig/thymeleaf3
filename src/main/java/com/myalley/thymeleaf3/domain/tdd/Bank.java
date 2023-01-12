package com.myalley.thymeleaf3.domain.tdd;

public class Bank {
    public Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}
