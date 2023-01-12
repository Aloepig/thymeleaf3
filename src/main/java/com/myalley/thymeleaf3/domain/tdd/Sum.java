package com.myalley.thymeleaf3.domain.tdd;

public class Sum implements Expression{
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to, Bank bank) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}
