package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.move.MoveMoney;
import org.junit.Assert;
import org.junit.Test;

public class MoveMoneyTest {

    @Test
    public void test() {
        MoveMoney moveMoney = new MoveMoney();

        Assert.assertEquals(4, moveMoney.solve(1, 1, 1, 1, 6));
        Assert.assertEquals(1, moveMoney.solve(1, 3));
        Assert.assertEquals(3, moveMoney.solve(1, 3, 2, 5, 4));

    }
}
