package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a9012_Bracket.Bracket;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BracketTest {

    @Test
    public void test() {
        assertEquals("NO", Bracket.solveToString("(())())"));
        assertEquals("NO", Bracket.solveToString("(((()())()"));
        assertEquals("YES", Bracket.solveToString("(()())((()))"));
        assertEquals("NO", Bracket.solveToString("((()()(()))(((())))()"));
        assertEquals("YES", Bracket.solveToString("()()()()(()()())()"));
        assertEquals("NO", Bracket.solveToString("(()((())()("));
    }
}
