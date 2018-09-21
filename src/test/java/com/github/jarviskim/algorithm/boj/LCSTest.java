package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a9251_LCS.LCS;
import org.junit.Assert;
import org.junit.Test;

public class LCSTest {

    @Test
    public void test() {
        Assert.assertEquals(4, LCS.solve("ACAYKP".toCharArray(), "CAPCAK".toCharArray()));
        Assert.assertEquals(1, LCS.solve("ABCD".toCharArray(), "EDCA".toCharArray()));
        Assert.assertEquals(2, LCS.solve("ABCD".toCharArray(), "EACB".toCharArray()));
        Assert.assertEquals(1, LCS.solve("AA".toCharArray(), "A".toCharArray()));
        Assert.assertEquals(3, LCS.solve("ABAB".toCharArray(), "AAB".toCharArray()));
        Assert.assertEquals(2, LCS.solve("AAA".toCharArray(), "AA".toCharArray()));

        Assert.assertEquals(3, LCS.solve("ABCDGH".toCharArray(), "AEDFHR".toCharArray()));
        Assert.assertEquals(4, LCS.solve("GXTXAYB".toCharArray(), "GTAB".toCharArray()));
    }
}
