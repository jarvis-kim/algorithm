package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Quiz22Test {

    @Test
    public void testSearch() throws Exception {
        int[] case_1_arr_input = {1, 2, 3, 7, 10};
        int case_1_target_input = 7;

        int[] case_2_arr_input = {-5, 3, 0, 1};
        int case_2_target_input = 0;

        int[] case_3_arr_input = {1, 4, 5, 6, 8, 9};
        int case_3_target_input = 10;

        assertTrue(Quiz22.search(case_1_arr_input, case_1_target_input));
        assertTrue(Quiz22.search(case_2_arr_input, case_2_target_input));
        assertFalse(Quiz22.search(case_3_arr_input, case_3_target_input));
    }

}