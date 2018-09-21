package com.github.jarviskim.algorithm.programmers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HavenOfPedestrianTest {

    @Test
    public void test() {
        int case1_input_m = 3;
        int case1_input_n = 3;
        int[][] case1_input_map = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int case1_expected = 6;

        int case2_input_m = 3;
        int case2_input_n = 6;
        int[][] case2_input_map = {
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}};
        int case2_expected = 2;

        int case3_input_m = 2;
        int case3_input_n = 2;
        int[][] case3_input_map = {
                {0, 2},
                {2, 0}};
        int case3_expected = 0;

        int case4_input_m = 3;
        int case4_input_n = 6;
        int[][] case4_input_map = {
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 0, 2},
                {1, 0, 0, 2, 2, 0}};
        int case4_expected = 2;

        int case5_input_m = 3;
        int case5_input_n = 6;
        int[][] case5_input_map = {
                {0, 0, 0, 0, 0, 2},
                {2, 0, 2, 2, 0, 0},
                {1, 0, 2, 2, 2, 0}};
        int case5_expected = 3;

        int case6_input_m = 3;
        int case6_input_n = 6;
        int[][] case6_input_map = {
                {0, 0, 2, 0, 0, 2},
                {2, 0, 0, 2, 0, 2},
                {1, 0, 2, 2, 2, 0}};
        int case6_expected = 1;

        int case7_input_m = 3;
        int case7_input_n = 3;
        int[][] case7_input_map = {
                {0, 2, 2},
                {2, 2, 2},
                {2, 2, 0}};
        int case7_expected = 0;

        HavenOfPedestrian.Solution solution = new HavenOfPedestrian.Solution();

        assertEquals(case1_expected, solution.solution(case1_input_m, case1_input_n, case1_input_map));
        assertEquals(case2_expected, solution.solution(case2_input_m, case2_input_n, case2_input_map));
        assertEquals(case3_expected, solution.solution(case3_input_m, case3_input_n, case3_input_map));
        assertEquals(case4_expected, solution.solution(case4_input_m, case4_input_n, case4_input_map));
        assertEquals(case5_expected, solution.solution(case5_input_m, case5_input_n, case5_input_map));
        assertEquals(case6_expected, solution.solution(case6_input_m, case6_input_n, case6_input_map));
        assertEquals(case7_expected, solution.solution(case7_input_m, case7_input_n, case7_input_map));
    }
}