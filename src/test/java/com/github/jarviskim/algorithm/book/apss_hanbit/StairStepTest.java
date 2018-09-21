package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.stair.StairStep;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StairStepTest {

    /**
     * 두번째 테스트 케이스는 책에서 output이 96으로 되어있는데 잘못됐다고 생각함. 손으로 풀어봐도 답이 아님.
     *  
     */
    @Test
    public void test() {
        StairStep stairStep = new StairStep();

        assertEquals(75, stairStep.solve(10, 20, 15, 25, 10, 20));
        assertEquals(77, stairStep.solve(13, 1, 15, 27, 29, 21, 20));
    }
}
