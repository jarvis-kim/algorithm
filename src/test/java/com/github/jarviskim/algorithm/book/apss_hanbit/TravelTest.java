package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.travel.Travel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TravelTest {

    @Test
    public void test() {
        Travel travel = new Travel();

        /* Case 1*/
        int[][] case1 = new int[][] {
                { 0, 14, 4, 10, 20 },
                { 14, 0, 7, 8, 7 },
                { 4, 5, 0, 7, 16 },
                { 11, 7, 9, 0, 2 },
                { 18, 7, 17, 4, 0 }
        };

        assertEquals(30, travel.minimumCost(case1));

        int[][] case2 = new int[][] {
                { 9, 9, 2, 9, 5 },
                { 6, 3, 5, 1, 5 },
                { 1, 8, 3, 3, 3 },
                { 6, 0, 9, 6, 8 },
                { 6, 6, 9, 4, 8 }
        };
        assertEquals(18, travel.minimumCost(case2));

        int[][] case3 = new int[][] {
                { 0, 2, 9, -1 },
                { 1, 0, 6, 4 },
                { -1, 7, 0, 8 },
                { 6, 3, -1, 0 }
        };
        assertEquals(21, travel.minimumCost(case3));
        /* length[ v1, v3, v4, v2, v1 ] */
    }
}
