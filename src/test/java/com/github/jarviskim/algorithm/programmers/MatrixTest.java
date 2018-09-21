package com.github.jarviskim.algorithm.programmers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void matrix() {
        int[][] case_1 = {{5, 3}, {3, 2}, {2, 6}};
        int[][] case_2 = {{5, 2}, {2, 3}, {3, 4}, {4, 6}, {6, 7}, {7, 8}};

        int answer_1 = 90;
        int answer_2 = 348;

        Matrix matrix = new Matrix();
        assertEquals(answer_1, matrix.matrix(case_1));
        assertEquals(answer_2, matrix.matrix(case_2));
    }
}