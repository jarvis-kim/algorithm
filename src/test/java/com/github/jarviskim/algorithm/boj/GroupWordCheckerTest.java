package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1316_GroupWordChecker.GroupWordChecker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupWordCheckerTest {

    @Test
    public void test() {
        assertEquals(1, GroupWordChecker.solve("happy"));
        assertEquals(1, GroupWordChecker.solve("new"));
        assertEquals(1, GroupWordChecker.solve("year"));
        assertEquals(1, GroupWordChecker.solve("aabbbcc"));
        assertEquals(0, GroupWordChecker.solve("aabbbccb"));
        assertEquals(0, GroupWordChecker.solve("aabaccdd"));
    }
}
