package com.myalley.thymeleaf3.domain.tdd;

public interface Expression {
    Money reduce(String to, Bank bank);
}