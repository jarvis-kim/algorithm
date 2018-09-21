package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2504_BracketValue.BracketValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BracketValueTest {

    @Test
    public void test() {
        assertEquals(3, BracketValue.solve("[]"));
        assertEquals(6, BracketValue.solve("[][]"));
        assertEquals(28, BracketValue.solve("(()[[]])([])"));

        assertEquals(0, BracketValue.solve("(()[[]])([])("));
        assertEquals(0, BracketValue.solve("(()[[]])([]))"));
        assertEquals(0, BracketValue.solve(""));
        assertEquals(0, BracketValue.solve("(()[[])([]))"));
    }
}
