package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Test;

import static com.github.jarviskim.algorithm.mailprogramming.Quiz11.validEncoded;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Quiz11Test {

    @Test
    public void testValidEncoded() {
        assertTrue(validEncoded("EGG", "FOO"));
        assertTrue(validEncoded("ABBCD", "APPLE"));
        assertFalse(validEncoded("AAB", "FOO"));
    }
}