package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a7576_Tomato.Tomato;
import org.junit.Assert;
import org.junit.Test;

public class TomatoTest {

    @Test
    public void test() {
        int[][] data1 = new int[][] {
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 1 }
        };
        Assert.assertEquals(8, Tomato.solve(data1));
    }

    @Test
    public void test2() {
        int[][] data1 = new int[][] {
                new int[] { 0, 0 },
                new int[] { 0, 0 },
        };
        Assert.assertEquals(-1, Tomato.solve(data1));
    }

    @Test
    public void test3() {
        int[][] data1 = new int[][] {
                new int[] { 1 },
        };
        Assert.assertEquals(0, Tomato.solve(data1));
    }

    @Test
    public void test4() {
        int[][] data1 = new int[][] {
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 }
        };
        Assert.assertEquals(0, Tomato.solve(data1));
    }

    @Test
    public void test5() {
        int[][] data1 = new int[][] {
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 0, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 }
        };
        Assert.assertEquals(1, Tomato.solve(data1));
    }

    @Test
    public void test6() {
        int[][] data1 = new int[][] {
                new int[] { 1, -1 },
                new int[] { -1, 0 },
        };
        Assert.assertEquals(-1, Tomato.solve(data1));
    }
}
