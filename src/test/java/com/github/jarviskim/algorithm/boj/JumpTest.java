package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1890_Jump.Jump;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class JumpTest {

    @Test
    public void test() {
        int[][] map = new int[][] {
                new int[] { 2, 3, 3, 1 },
                new int[] { 1, 2, 1, 3 },
                new int[] { 1, 2, 3, 1 },
                new int[] { 3, 1, 1, 0 }
        };

        Assert.assertEquals(new BigDecimal(3), Jump.solve(map));

    }
}
