package com.myalley.thymeleaf3.TDD;

import com.myalley.thymeleaf3.domain.tdd.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void testMulti() {
        Money five = Money.dollar(5);
        Assertions.assertEquals(Money.dollar(10), five.times(2));
        Assertions.assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        Assertions.assertEquals(Money.dollar(5), Money.dollar(5));
        Assertions.assertNotEquals(Money.dollar(6), Money.dollar(5));
        Assertions.assertEquals(Money.franc(5), Money.franc(5));
    }

}
