package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a11051_BinomialCoefficient2.BinomialCoefficient2;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinomialCoefficient2Test {

    @Test
    public void test() {
        assertEquals(10, BinomialCoefficient2.solve(5, 2));
        assertEquals(1, BinomialCoefficient2.solve(1, 0));
        assertEquals(1, BinomialCoefficient2.solve(1, 1));
    }

    @Test
    public void testAll() {
        final int N = 1000;

        for ( int n = 1; n < N; n++ ) {
            for ( int k = 1; k <= n; k++ ) {
                if ( BinomialCoefficient2.solve(n, k) < 0 ) {
                    System.out.println(BinomialCoefficient2.solve(n, k));
                }
            }
        }
    }
}
