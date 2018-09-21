package com.github.jarviskim.algorithm.programmers;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FriendsTest {

    @Test
    public void testSolution() {
        Friends.Solution solution = new Friends.Solution();

        int case1_input_m = 6;
        int case1_input_n = 4;
        int[][] case1_input_map = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};
        int[] case1_expected = {4, 5};

        int case2_input_m = 3;
        int case2_input_n = 4;
        int[][] case2_input_map = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 3}};
        int[] case2_expected = {1, 1};

        int case3_input_m = 3;
        int case3_input_n = 4;
        int[][] case3_input_map = {
                {2, 0, 0, 0},
                {0, 2, 2, 0},
                {0, 0, 0, 3}};
        int[] case3_expected = {3, 2};

        int case4_input_m = 3;
        int case4_input_n = 4;
        int[][] case4_input_map = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        int[] case4_expected = {0, 0};

        int case5_input_m = 3;
        int case5_input_n = 4;
        int[][] case5_input_map = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        int[] case5_expected = {1, 12};

        int case6_input_m = 13;
        int case6_input_n = 16;
        int[][] case6_input_map = {
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
        int[] case6_expected = {12, 120};

        int case7_input_m = 4;
        int case7_input_n = 4;
        int[][] case7_input_map = {
                {1, 0, 2, 1},
                {1, 2, 1, 1},
                {1, 1, 2, 1},
                {1, 1, 1, 1}};
        int[] case7_expected = {4, 12};

        int case8_input_m = 4;
        int case8_input_n = 4;
        int[][] case8_input_map = {
                {1, 1, 0, 0},
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        int[] case8_expected = {1, 12};


        int case9_input_m = 13;
        int case9_input_n = 16;
        int[][] case9_input_picture = {
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
        };
        int[] case9_expected = {12, 120};

        int case10_input_m = 6;
        int case10_input_n = 4;
        int[][] case10_input_picture = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };
        int[] case10_expected = {2, 6};

        assertArrayEquals(case1_expected, solution.solution(case1_input_m, case1_input_n, case1_input_map));
        assertArrayEquals(case2_expected, solution.solution(case2_input_m, case2_input_n, case2_input_map));
        assertArrayEquals(case3_expected, solution.solution(case3_input_m, case3_input_n, case3_input_map));
        assertArrayEquals(case4_expected, solution.solution(case4_input_m, case4_input_n, case4_input_map));
        assertArrayEquals(case5_expected, solution.solution(case5_input_m, case5_input_n, case5_input_map));
        assertArrayEquals(case6_expected, solution.solution(case6_input_m, case6_input_n, case6_input_map));
        assertArrayEquals(case7_expected, solution.solution(case7_input_m, case7_input_n, case7_input_map));
        assertArrayEquals(case8_expected, solution.solution(case8_input_m, case8_input_n, case8_input_map));
        assertArrayEquals(case9_expected, solution.solution(case9_input_m, case9_input_n, case9_input_picture));
        assertArrayEquals(case10_expected, solution.solution(case10_input_m, case10_input_n, case10_input_picture));
    }
}