package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2225_SumCount.SumCount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumCountTest {

    @Test
    public void test() {
        assertEquals(21, SumCount.solve(20, 2));

        for ( int i = 1; i <= 200; i++ ) {
            for ( int j = 1; j <= 200; j++ ) {
                System.out.printf("n : %3d, k : %3d - %d\n", i, j, SumCount.solve(i, j));
            }
        }
    }
}
