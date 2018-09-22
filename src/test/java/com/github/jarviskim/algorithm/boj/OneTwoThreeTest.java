package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a9095_OneTwoThree.OneTwoThree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OneTwoThreeTest {

    @Test(timeout = 1000)
    public void test() {
        assertEquals(7, OneTwoThree.solve(4));
        assertEquals(44, OneTwoThree.solve(7));
        assertEquals(274, OneTwoThree.solve(10));
        for ( int x = 0; x < 11; x++ ) {
            System.out.println(OneTwoThree.solve(x));
        }
    }
}
