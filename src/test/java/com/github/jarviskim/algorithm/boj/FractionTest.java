package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1193_Fraction.Fraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {

    @Test
    public void test() {
        assertEquals("2/4", Fraction.solve(14));
        assertEquals("1/1", Fraction.solve(1));
        assertEquals("2/2", Fraction.solve(5));
    }
}
