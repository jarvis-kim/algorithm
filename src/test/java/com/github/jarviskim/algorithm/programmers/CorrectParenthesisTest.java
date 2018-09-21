package com.github.jarviskim.algorithm.programmers;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CorrectParenthesisTest {

    @Test
    public void testParenthesisCase() {
        CorrectParenthesis cp = new CorrectParenthesis();
        assertEquals(new BigInteger("1"), cp.parenthesisCase(1));
        assertEquals(new BigInteger("2"), cp.parenthesisCase(2));
        assertEquals(new BigInteger("5"), cp.parenthesisCase(3));
        assertEquals(new BigInteger("14"), cp.parenthesisCase(4));
        assertEquals(new BigInteger("42"), cp.parenthesisCase(5));
        assertEquals(new BigInteger("132"), cp.parenthesisCase(6));
        assertEquals(new BigInteger("429"), cp.parenthesisCase(7));
    }
}
