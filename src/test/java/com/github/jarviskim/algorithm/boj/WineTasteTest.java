package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2516_WineTaste.WineTaste;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WineTasteTest {

    @Test
    public void test() {
        assertEquals(33, WineTaste.solve(6, 10, 13, 9, 8, 1));
        assertEquals(40, WineTaste.solve(4, 5, 1, 1, 16, 15));
        assertEquals(4000, WineTaste.solve(1000, 1000, 1, 1, 1000, 1000));
        assertEquals(4000, WineTaste.solve(1000, 1000, 1, 1, 1000, 1000));
        assertEquals(30, WineTaste.solve(4, 5, 1, 1, 10, 11));
        assertEquals(5, WineTaste.solve(3, 2, 1));
        assertEquals(/*4254*/4040, WineTaste.solve(977, 200, 517, 851, 23, 662, 880, 815/*, 26, 214*/));
        assertEquals(4254, WineTaste.solve(977, 200, 517, 851, 23, 662, 880, 815, 26, 214));
        assertEquals(16, WineTaste.solve(6, 10));
        assertEquals(6, WineTaste.solve(6));
    }

    @Test
    public void testRecursive() {
        assertEquals(23, new WineTaste(6, 10, 13).solveWineTaste(2, 0));
        assertEquals(33, new WineTaste(6, 10, 13, 9, 8, 1).solveWineTaste(5, 0));
        assertEquals(40, new WineTaste(4, 5, 1, 1, 16, 15).solveWineTaste(5, 0));
        assertEquals(4000, new WineTaste(1000, 1000, 1, 1, 1000, 1000).solveWineTaste(5, 0));
        assertEquals(1000, new WineTaste(1000).solveWineTaste(0, 0));
        assertEquals(30, new WineTaste(4, 5, 1, 1, 10, 11).solveWineTaste(5, 0));
        assertEquals(5, new WineTaste(3, 2, 1).solveWineTaste(2, 0));
        assertEquals(/*4254*/4040, new WineTaste(977, 200, 517, 851, 23, 662, 880, 815/*, 26, 214*/).solveWineTaste(7, 0));
        assertEquals(4254, new WineTaste(977, 200, 517, 851, 23, 662, 880, 815, 26, 214).solveWineTaste2(9, 0));
        assertEquals(16, new WineTaste(6, 10).solveWineTaste(1, 0));
        assertEquals(6, new WineTaste(6).solveWineTaste(0, 0));
    }
    @Test
    public void testRecursiveNoneMemorization() {
        assertEquals(23, new WineTaste(6, 10, 13).solveWineTaste2(2, 0));
        assertEquals(33, new WineTaste(6, 10, 13, 9, 8, 1).solveWineTaste2(5, 0));
        assertEquals(40, new WineTaste(4, 5, 1, 1, 16, 15).solveWineTaste2(5, 0));
        assertEquals(4000, new WineTaste(1000, 1000, 1, 1, 1000, 1000).solveWineTaste2(5, 0));
        assertEquals(1000, new WineTaste(1000).solveWineTaste2(0, 0));
        assertEquals(30, new WineTaste(4, 5, 1, 1, 10, 11).solveWineTaste2(5, 0));
        assertEquals(5, new WineTaste(3, 2, 1).solveWineTaste2(2, 0));
        assertEquals(/*4254*/4040, new WineTaste(977, 200, 517, 851, 23, 662, 880, 815/*, 26, 214*/).solveWineTaste2(7, 0));
        assertEquals(4254, new WineTaste(977, 200, 517, 851, 23, 662, 880, 815, 26, 214).solveWineTaste2(9, 0));
    }
}