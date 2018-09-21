package com.github.jarviskim.algorithm.programmers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestSquareTest {

    @Test
    public void test() {
        LargestSquare test = new LargestSquare();
        char[][] board = {
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'X', 'X', 'X'}};

        assertEquals(9, test.findLargestSquare(board));

        char[][] board2 = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O', 'X'}};

        assertEquals(4, test.findLargestSquare(board2));

        char[][] board3 = {
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X'}};

        assertEquals(16, test.findLargestSquare(board3));

        char[][] board4 = {
                {'O', 'X', 'X', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X'}};

        assertEquals(9, test.findLargestSquare(board4));

        char[][] board5 = {
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X'}};

        assertEquals(4, test.findLargestSquare(board5));
    }

    @Test
    public void test2() {
        LargestSquare test = new LargestSquare();
        char[][] board = {
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'X', 'X', 'X'}};

        assertEquals(9, test.findLargestSquare2(board));

        char[][] board2 = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O', 'X'}};

        assertEquals(4, test.findLargestSquare2(board2));

        char[][] board3 = {
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X'}};

        assertEquals(16, test.findLargestSquare2(board3));

        char[][] board4 = {
                {'O', 'X', 'X', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X'}};

        assertEquals(9, test.findLargestSquare2(board4));

        char[][] board5 = {
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X'}};

        assertEquals(4, test.findLargestSquare2(board5));
    }
}
