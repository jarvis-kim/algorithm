package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a10809_FindAlphabet.FindAlphabet;
import org.junit.Assert;
import org.junit.Test;

public class FindAlphabetTest {

    @Test
    public void tes() {
        Assert.assertArrayEquals(new int[] { 1, 0, -1, -1, 2, -1, -1, -1, -1, 4, 3, -1, -1, 7, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, FindAlphabet.solve("baekjoon"));
    }
}
