package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2579_StairStep.StairStep;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StairStepTest {

    /**
     * history of fail
     */
    @Test
    public void test() {
        assertEquals(75, StairStep.solveByRecursive(new int[] {10, 20, 15, 25, 10, 20}, 5, 0));
        assertEquals(96, StairStep.solveByRecursive(new int[] {13, 1, 15, 27, 29, 21, 20}, 6, 0 ));
        assertEquals(3, StairStep.solveByRecursive(new int[] {1, 1, 0, 0, 1, 1}, 5, 0));
        assertEquals(4, StairStep.solveByRecursive(new int[] {1, 1, 0, 1, 1}, 4, 0));
        /**
         * fail test
         */
        assertEquals(116, StairStep.solveByRecursive(new int[] {1, 10, 10, 3, 5, 100}, 5, 0));
    }

    @Test
    public void test2() {
        assertEquals(75, StairStep.solveByDynamic(new int[] {10, 20, 15, 25, 10, 20}));
        assertEquals(96, StairStep.solveByDynamic(new int[] {13, 1, 15, 27, 29, 21, 20}));
        assertEquals(3, StairStep.solveByDynamic(new int[] {1, 1, 0, 0, 1, 1}));
        assertEquals(4, StairStep.solveByDynamic(new int[] {1, 1, 0, 1, 1}));
        assertEquals(125, StairStep.solveByDynamic(new int[] {1, 10, 10, 3, 5, 100}));
    }
}