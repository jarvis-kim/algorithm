package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1697_HideAndSeek.HideAndSeek;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HideAndSeekTest {

    private final static long LIMIT_TIME = 2 * 1000;

    @Test(timeout = LIMIT_TIME)
    public void test() {
        HideAndSeek hideAndSeek = new HideAndSeek();
        System.out.println(hideAndSeek.solve(5, 11));
        hideAndSeek.solve(0, 100000);
        hideAndSeek.solve(1, 99999);
        hideAndSeek.solve(0, 99999);
        hideAndSeek.solve(3, 99999);
        hideAndSeek.solve(0, 99999);
        hideAndSeek.solve(99999, 99999);
        hideAndSeek.solve(0, 0);
        hideAndSeek.solve(100000, 100000);
        hideAndSeek.solve(400, 100);


//        assertEquals(4, hideAndSeek.solve(5, 17));

    }

    @Test(timeout = LIMIT_TIME)
    public void test2() {
        HideAndSeek hideAndSeek = new HideAndSeek();
        assertEquals(18, HideAndSeek.solve(6, 100000));
    }

}
