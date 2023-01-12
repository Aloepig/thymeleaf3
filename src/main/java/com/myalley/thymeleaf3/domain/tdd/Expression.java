package com.myalley.thymeleaf3.domain.tdd;

public interface Expression {
    Money reduce(String to, Bank bank);

    Expression plus(Expression addend);

    Expression times(int multi);

}