package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1005_AcmCraft.AcmCraft;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcmCraftTest {

    @Test
    public void test() throws InterruptedException {

        int n = 4;
        int[] times = new int[ n + 1 ];
        times[ 1 ] = 10;
        times[ 2 ] = 1;
        times[ 3 ] = 100;
        times[ 4 ] = 10;

        boolean[][] map = new boolean[ n + 1 ][ n + 1 ];
        map[ 2 ][ 1 ] = true;
        map[ 3 ][ 1 ] = true;
        map[ 4 ][ 2 ] = true;
        map[ 4 ][ 3 ] = true;

        assertEquals(120, AcmCraft.solve2(map, times, 4));

        n = 8;
        times = new int[ n + 1 ];
        times[ 1 ] = 10;
        times[ 2 ] = 20;
        times[ 3 ] = 1;
        times[ 4 ] = 5;
        times[ 5 ] = 8;
        times[ 6 ] = 7;
        times[ 7 ] = 1;
        times[ 8 ] = 43;

        map = new boolean[ n + 1 ][ n + 1 ];
        map[ 2 ][ 1 ] = true;
        map[ 3 ][ 1 ] = true;
        map[ 4 ][ 2 ] = true;
        map[ 5 ][ 2 ] = true;
        map[ 6 ][ 3 ] = true;
        map[ 7 ][ 5 ] = true;
        map[ 7 ][ 6 ] = true;
        map[ 8 ][ 7 ] = true;

        assertEquals(39, AcmCraft.solve2(map, times, 7 ));
    }

    @Test
    public void test2() {
        int[] times = new int[ 8 ];
        times[ 1 - 1 ] = 10;
        times[ 2 - 1 ] = 20;
        times[ 3 - 1 ] = 1;
        times[ 4 - 1 ] = 5;
        times[ 5 - 1 ] = 8;
        times[ 6 - 1 ] = 7;
        times[ 7 - 1 ] = 1;
        times[ 8 - 1 ] = 43;

        int[][] map = new int[ 8 ][ 8 ];
        map[ 2 - 1 ][ 1 - 1 ] = 1;
        map[ 3 - 1 ][ 1 - 1 ] = 1;
        map[ 4 - 1 ][ 2 - 1 ] = 1;
        map[ 5 - 1 ][ 2 - 1 ] = 1;
        map[ 6 - 1 ][ 3 - 1 ] = 1;
        map[ 7 - 1 ][ 5 - 1 ] = 1;
        map[ 7 - 1 ][ 6 - 1 ] = 1;
        map[ 8 - 1 ][ 7 - 1 ] = 1;

        assertEquals(39, AcmCraft.solve(map, times, 7 - 1));
    }
}
