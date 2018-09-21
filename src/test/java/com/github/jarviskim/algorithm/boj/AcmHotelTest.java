package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a10250_AcmHotel.AcmHotel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcmHotelTest {

    @Test
    public void test() {
        assertEquals(402, AcmHotel.solve(6, 12, 10));
        assertEquals(1203, AcmHotel.solve(30, 50, 72));
        assertEquals(110, AcmHotel.solve(6, 12, 55));
        assertEquals(101, AcmHotel.solve(10, 10, 1));
        assertEquals(101, AcmHotel.solve(1, 1, 1));
        assertEquals(1001, AcmHotel.solve(10, 10, 10));
    }


}
