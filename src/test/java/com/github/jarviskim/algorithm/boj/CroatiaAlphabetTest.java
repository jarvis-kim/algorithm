package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2941_CroatiaAlphabet.CroatiaAlphabet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CroatiaAlphabetTest {

    @Test
    public void test() {
        assertEquals(6, CroatiaAlphabet.solve("ljes=njak"));
    }
}
