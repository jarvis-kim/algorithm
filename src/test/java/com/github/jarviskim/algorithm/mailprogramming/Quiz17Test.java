package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Test;

import static com.github.jarviskim.algorithm.mailprogramming.Quiz17.solve;
import static org.junit.Assert.assertEquals;

public class Quiz17Test {

    @Test
    public void testSolve() {
        // @formatter:off
        int[][] case_1 =
                {{1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}};
        // @formatter:on
        int expectedCase_1 = 8;

        int[][] case_2 =
                {{1, 0, 0, 1, 1, 0},
                        {1, 0, 0, 1, 0, 0},
                        {1, 1, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1}};
        // @formatter:on
        int expectedCase_2 = -1;


        assertEquals(expectedCase_1, solve(case_1, new Quiz17.Pos(0, 0), new Quiz17.Pos(4, 0)));
        assertEquals(expectedCase_2, solve(case_2, new Quiz17.Pos(0, 0), new Quiz17.Pos(5, 0)));
    }
}