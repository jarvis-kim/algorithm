package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a11057_AscentNumber.AscentNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AscentNumberTest {

    @Test(timeout = 1000)
    public void test() {
        assertEquals(10, AscentNumber.solve(1));
        assertEquals(55, AscentNumber.solve(2));
        assertEquals(220, AscentNumber.solve(3));
    }
}
