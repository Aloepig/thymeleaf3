package com.myalley.thymeleaf3.domain.tdd;

public class Sum implements Expression{
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to, Bank bank) {
        int amount = augend.reduce(to, bank).amount + addend.reduce(to, bank).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression times(int multi) {
        return new Sum(augend.times(multi), addend.times(multi) );
    }
}
