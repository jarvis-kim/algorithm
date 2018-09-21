package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2675_RepeatString.RepeatString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepeatStringTest {

    @Test
    public void test() {
        assertEquals("AAABBBCCC", RepeatString.solve(3, "ABC"));
        assertEquals("/////HHHHHTTTTTPPPPP", RepeatString.solve(5, "/HTP"));
    }
}
