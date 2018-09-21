package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1874_StackSequence.StackSequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackSequenceTest {

    @Test
    public void test() {
        assertEquals("++++--++-++-----", StackSequence.solve(4, 3, 6, 8, 7, 5, 2, 1));
        assertEquals("+-+-+-+-", StackSequence.solve(1, 2, 3, 4));
        assertEquals("++++----", StackSequence.solve(4, 3, 2, 1));
    }
}
