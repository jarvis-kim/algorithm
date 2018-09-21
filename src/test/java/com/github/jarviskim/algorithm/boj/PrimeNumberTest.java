package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1978_prime_number.PrimeNumber;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeNumberTest {

    @Test
    public void testPrimeNumber() {
        assertFalse(PrimeNumber.checkPrimeNumber(1));
        assertTrue(PrimeNumber.checkPrimeNumber(2));
        assertTrue(PrimeNumber.checkPrimeNumber(3));
        assertFalse(PrimeNumber.checkPrimeNumber(4));
        assertTrue(PrimeNumber.checkPrimeNumber(5));
        assertFalse(PrimeNumber.checkPrimeNumber(6));
        assertTrue(PrimeNumber.checkPrimeNumber(7));
        assertFalse(PrimeNumber.checkPrimeNumber(8));
        assertFalse(PrimeNumber.checkPrimeNumber(9));

        assertFalse(PrimeNumber.checkPrimeNumber(10));
        assertTrue(PrimeNumber.checkPrimeNumber(11));
        assertFalse(PrimeNumber.checkPrimeNumber(12));
        assertTrue(PrimeNumber.checkPrimeNumber(13));
        assertFalse(PrimeNumber.checkPrimeNumber(14));
        assertFalse(PrimeNumber.checkPrimeNumber(15));
        assertFalse(PrimeNumber.checkPrimeNumber(16));
        assertTrue(PrimeNumber.checkPrimeNumber(17));
        assertFalse(PrimeNumber.checkPrimeNumber(18));
        assertTrue(PrimeNumber.checkPrimeNumber(19));

        assertFalse(PrimeNumber.checkPrimeNumber(20));
        assertFalse(PrimeNumber.checkPrimeNumber(21));
        assertFalse(PrimeNumber.checkPrimeNumber(22));
        assertTrue(PrimeNumber.checkPrimeNumber(23));
        assertFalse(PrimeNumber.checkPrimeNumber(24));
        assertFalse(PrimeNumber.checkPrimeNumber(25));
        assertFalse(PrimeNumber.checkPrimeNumber(26));
        assertFalse(PrimeNumber.checkPrimeNumber(27));
        assertFalse(PrimeNumber.checkPrimeNumber(28));
        assertTrue(PrimeNumber.checkPrimeNumber(29));
    }
}
