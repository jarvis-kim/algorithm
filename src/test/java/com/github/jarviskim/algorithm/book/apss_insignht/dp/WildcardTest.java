package com.github.jarviskim.algorithm.book.apss_insignht.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WildcardTest {

    @Test
    public void match() {
        String pattern_case1 = "abcd";
        String input_case1 = "abcd";
        boolean expected_case1 = true;

        String pattern_case2 = "abcd";
        String input_case2 = "abbd";
        boolean expected_case2 = false;

        String pattern_case3 = "abcd";
        String input_case3 = "abcdefg";
        boolean expected_case3 = false;

        String pattern_case4 = "he?p";
        String input_case4 = "help";
        boolean expected_case4 = true;

        String pattern_case5 = "he?p";
        String input_case5 = "heap";
        boolean expected_case5 = true;

        String pattern_case6 = "he?p";
        String input_case6 = "heapp";
        boolean expected_case6 = false;

        String pattern_case7 = "*p*";
        String input_case7 = "help";
        boolean expected_case7 = true;

        String pattern_case8 = "*p*";
        String input_case8 = "papa";
        boolean expected_case8 = true;

        String pattern_case9 = "*p*";
        String input_case9 = "hello";
        boolean expected_case9 = false;

        assertEquals(expected_case1, Wildcard.match(pattern_case1, input_case1));
        assertEquals(expected_case2, Wildcard.match(pattern_case2, input_case2));
        assertEquals(expected_case3, Wildcard.match(pattern_case3, input_case3));
        assertEquals(expected_case4, Wildcard.match(pattern_case4, input_case4));
        assertEquals(expected_case5, Wildcard.match(pattern_case5, input_case5));
        assertEquals(expected_case6, Wildcard.match(pattern_case6, input_case6));
        assertEquals(expected_case7, Wildcard.match(pattern_case7, input_case7));
        assertEquals(expected_case8, Wildcard.match(pattern_case8, input_case8));
        assertEquals(expected_case9, Wildcard.match(pattern_case9, input_case9));

    }
}