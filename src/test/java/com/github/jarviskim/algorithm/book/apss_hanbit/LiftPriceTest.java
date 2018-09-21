package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.lift.LiftPrice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LiftPriceTest {

    @Test
    public void test() {
        LiftPrice liftPrice = new LiftPrice(15, 21, 31, 40, 49, 58, 69, 79, 90, 101);

        assertEquals(147, liftPrice.min(15));

        liftPrice = new LiftPrice(12, 20, 30, 40, 25, 60, 70, 80, 90, 11);
        assertEquals(34, liftPrice.min(21));

    }
}
