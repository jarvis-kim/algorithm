package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1850_NumberOneGcm.NumberOneGcm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOneGcmTest {

    @Test
    public void test() {
        assertEquals(1, NumberOneGcm.solve(3, 4));
        assertEquals(111, NumberOneGcm.solve(3, 6));
    }
}
