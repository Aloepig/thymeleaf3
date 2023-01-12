package com.myalley.thymeleaf3.domain.tdd;

import java.util.HashMap;

public class Bank {

    private final HashMap<Pair, Integer> rates = new HashMap<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(to, this);
    }

    public void addRate(String from, String to, int rate) {
        this.rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
    }
}
