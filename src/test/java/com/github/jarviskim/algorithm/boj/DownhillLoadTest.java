package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1502_DownhillLoad.DownhillLoad;
import org.junit.Assert;
import org.junit.Test;

public class DownhillLoadTest {

    @Test
    public void test() {
        int n = 4;
        int m = 5;

        int[][] map = new int[][] {
                new int[] { 50, 45, 37, 32, 30 },
                new int[] { 35, 50, 40, 20, 25 },
                new int[] { 30, 30, 25, 17, 28 },
                new int[] { 27, 24, 22, 15, 10 },
        };
        Assert.assertEquals(3, new DownhillLoad(map).solve(n - 1, m - 1));
    }

    @Test
    public void test2() {
        int n = 1;
        int m = 1;

        int[][] map = new int[][] {
                new int[] { 50 },
        };
        Assert.assertEquals(1, new DownhillLoad(map).solve(n - 1, m - 1));
    }

    @Test
    public void test3() {
        int n = 4;
        int m = 5;

        int[][] map = new int[][] {
                new int[] { 50, 45, 37, 32, 30 },
                new int[] { 35, 50, 40, 20, 28 },
                new int[] { 30, 30, 25, 17, 27 },
                new int[] { 27, 24, 22, 15, 10 },
        };
        Assert.assertEquals(5, new DownhillLoad(map).solve(n - 1, m - 1));
    }

    @Test
    public void test4() {
        int answer = 1;

        int[][] map = new int[][] {
                new int[] { 50, 45, 37, 32, 30 },
        };
        Assert.assertEquals(answer, new DownhillLoad(map).solve(map.length - 1, map[ 0 ].length - 1));
    }

    @Test
    public void test5() {
        int answer = 1;

        int[][] map = new int[][] {
                new int[] { 18, 17, 16, 15, 14 },
                new int[] { 2, 2, 2, 2, 13 },
                new int[] { 8, 9, 10, 11, 12 },
                new int[] { 7, 2, 2, 2, 2 },
                new int[] { 6, 5, 4, 3, 2 }
        };
        Assert.assertEquals(answer, new DownhillLoad(map).solve(map.length - 1, map[ 0 ].length - 1));
    }
}
