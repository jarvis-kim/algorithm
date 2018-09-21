package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1912_SequentialSum.SequentialSum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SequentialSumTest {

    @Test
    public void test() {
        assertEquals(33, SequentialSum.solve(10, -4, 3, 1, 5, 6, -35, 12, 21, -1));
        assertEquals(5, SequentialSum.solve(-1, 5));

        int[] inputs = new int[] { -13920, 2341, -14904, 12152, 8208, -8190, -9494, 10792, -5129, 2421, -3316, -4203, 4224, -7460,
                8801, -459, 8447, -14983, -7562, 6515, 786, 12579, -7659, -5633, -8847, 3899, 3178, -1944, -1982,
                8674, 2916, -18964, -3429, -3223, -13986, 1935, -3774, -9719, -18945, 1898, 10935, -7211, -11682,
                -4026, -2956, -16660, -14230, -6295, -19085, -3597 };

        assertEquals(20360, SequentialSum.solve(inputs));

        assertEquals(-1, SequentialSum.solve(-3, -1, -4, -2));
        assertEquals(21, SequentialSum.solve(4, 5, -3, 7, 8));
        assertEquals(15, SequentialSum.solve(4, 5, -10, 7, 8));
        assertEquals(101, SequentialSum.solve(-1, 2, 3, -3, 99));
        assertEquals(100, SequentialSum.solve(100, -100, 1));
        assertEquals(5, SequentialSum.solve(5, -1));
        assertEquals(6, SequentialSum.solve(5, -1, -1, -1, 4, -1));
        assertEquals(-2, SequentialSum.solve(-2, -2));
        assertEquals(-2, SequentialSum.solve(-2));
        assertEquals(1, SequentialSum.solve(1));
        
    }
}

