package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1475_RoomNumber.RoomNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomNumberTest {

    @Test
    public void testSolve() {
        assertEquals(2, RoomNumber.solve(9999));
        assertEquals(1, RoomNumber.solve(1234));
        assertEquals(2, RoomNumber.solve(6669));
        assertEquals(3, RoomNumber.solve(1232369969));

        /**
         * Fail..
         */
        assertEquals(1, RoomNumber.solve(0));
        assertEquals(2, RoomNumber.solve(1166));
    }

    @Test
    public void testSolve2() {
        assertEquals(2, RoomNumber.solve2("9999"));
        assertEquals(1, RoomNumber.solve2("1234"));
        assertEquals(2, RoomNumber.solve2("6669"));
        assertEquals(3, RoomNumber.solve2("1232369969"));

        assertEquals(1, RoomNumber.solve2("0"));
        assertEquals(2, RoomNumber.solve2("1166"));
    }


}
