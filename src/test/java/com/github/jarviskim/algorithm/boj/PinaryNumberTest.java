package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2193_PinaryNumber.PinaryNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PinaryNumberTest {

    @Test(timeout = 2000)
    public void test() {
        assertEquals(1, PinaryNumber.solve(1));
        assertEquals(1, PinaryNumber.solve(2));
        assertEquals(2, PinaryNumber.solve(3));
        assertEquals(3, PinaryNumber.solve(4));
        assertEquals(5, PinaryNumber.solve(5));

        for ( int i = 1; i <= 90; i++ ) {
            System.out.println(i + " : " + PinaryNumber.solve(i));
        }
    }
}
