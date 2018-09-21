package com.github.jarviskim.algorithm.programmers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IUTest {

    @Test
    public void test() {
        int case_1_input_n = 15;
        int case_1_expected = 1;

        int case_2_input_n = 24;
        int case_2_expected = 0;

        int case_3_input_n = 41;
        int case_3_expected = 2;

        int case_4_input_n = 2147483647;
        int case_4_expected = 1735;

        IU.Solution solution = new IU().createSolution();

        assertEquals(case_1_expected, solution.solution(case_1_input_n));
        assertEquals(case_2_expected, solution.solution(case_2_input_n));
        assertEquals(case_3_expected, solution.solution(case_3_input_n));
        assertEquals(case_4_expected, solution.solution(case_4_input_n));
    }
}