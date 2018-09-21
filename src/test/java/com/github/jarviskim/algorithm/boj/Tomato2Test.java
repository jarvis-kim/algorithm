package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a7569_Tomato2.Tomato2;
import org.junit.Assert;
import org.junit.Test;

public class Tomato2Test {

    @Test
    public void test() {
        int[][] floor = new int[][] {
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 1 }
        };
        int[][][] data1 = new int[ 1 ][][];
        data1[ 0 ] = floor;
        Assert.assertEquals(8, Tomato2.solve(data1));
    }

    @Test
    public void test2() {
        int[][] floor = new int[][] {
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 1 }
        };

        int[][] floor2 = new int[][] {
                new int[] { 1, 0, 0, 0, 0, 0 },
                new int[] { 0, -1, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, -1, 0 },
                new int[] { 0, 0, 0, 0, 0, 0 }
        };

        int[][][] data1 = new int[ 2 ][][];
        data1[ 0 ] = floor;
        data1[ 1 ] = floor2;

        Assert.assertEquals(4, Tomato2.solve(data1));
    }

    @Test
    public void test3() {
        int[][] floor = new int[][] {
                new int[] { 0, 0 },
                new int[] { 0, 1 }
        };

        int[][] floor2 = new int[][] {
                new int[] { 1, 0 },
                new int[] { 0, -1 }
        };

        int[][] floor3 = new int[][] {
                new int[] { 0, 0 },
                new int[] { 0, 0 }
        };

        int[][][] data1 = new int[ 3 ][][];
        data1[ 0 ] = floor;
        data1[ 1 ] = floor2;
        data1[ 2 ] = floor3;

        Assert.assertEquals(3, Tomato2.solve(data1));
    }
}
