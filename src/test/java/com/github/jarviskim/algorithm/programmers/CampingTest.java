package com.github.jarviskim.algorithm.programmers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CampingTest {

    @Test
    public void solution() {
        Camping camping = new Camping();

        int case_1_n = 4;
        int[][] case_1_data = {{0, 0}, {1, 1}, {0, 2}, {2, 0}};
        int case_1_expected = 3;

        int case_2_n = 1;
        int[][] case_2_data = {{0, 0}};
        int case_2_expected = 0;

        int case_3_n = 5;
        int[][] case_3_data = {{4, 1}, {7,3}, {6,2}, {2,4}, {2,3}};
        int case_3_expected = 7;

        assertEquals(case_1_expected, camping.solution(case_1_n, case_1_data));
        assertEquals(case_2_expected, camping.solution(case_2_n, case_2_data));
        assertEquals(case_3_expected, camping.solution(case_3_n, case_3_data));
    }
}
