package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2839_Secer.Secer;
import org.junit.Test;

public class SecerTest {

    @Test(timeout = 1000)
    public void test() {
        assertEquals(1, Secer.solve(3));
        assertEquals(-1, Secer.solve(4));
        assertEquals(2, Secer.solve(6));
        assertEquals(3, Secer.solve(9));
        assertEquals(2, Secer.solve(10));
        assertEquals(1, Secer.solve(3));
        assertEquals(4, Secer.solve(12));
        assertEquals(3, Secer.solve(13));
        assertEquals(3, Secer.solve(15));
        assertEquals(4, Secer.solve(16));
        assertEquals(4, Secer.solve(18));
        Secer.solve(1000);
    }

    @Test(timeout = 1000)
    public void test2() {
        assertEquals(1, Secer.solve2(3));
        assertEquals(-1, Secer.solve2(4));
        assertEquals(2, Secer.solve2(6));
        assertEquals(3, Secer.solve2(9));
        assertEquals(2, Secer.solve2(10));
        assertEquals(1, Secer.solve2(3));
        assertEquals(4, Secer.solve2(12));
        assertEquals(3, Secer.solve2(13));
        assertEquals(3, Secer.solve2(15));
        assertEquals(4, Secer.solve2(16));
        assertEquals(4, Secer.solve2(18));
        Secer.solve2(5000);
    }
}
