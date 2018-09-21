package com.github.jarviskim.algorithm.book.apss_insight.divide;

import com.github.jarviskim.algorithm.book.apss_insignht.divide.QuadTree;
import org.junit.Assert;
import org.junit.Test;

public class QuadTreeTest {

    @Test
    public void reverse() {
        QuadTree quadTree = new QuadTree();

        String case_1_input = "w";
        String case_1_expect = "w";

        String case_2_input     = "xbwwb";
        String case_2_expect    = "xwbbw";

        String case_3_input     = "xbwxwbbwb";
        String case_3_expect    = "xxbwwbbbw";

        String case_4_input     = "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";
        String case_4_expect    = "xxwbxwwxbbwwbwbxwbwwxwwwxbbwb";

        Assert.assertEquals(case_1_expect, quadTree.reverse(case_1_input));
        Assert.assertEquals(case_2_expect, quadTree.reverse(case_2_input));
        Assert.assertEquals(case_3_expect, quadTree.reverse(case_3_input));
        Assert.assertEquals(case_4_expect, quadTree.reverse(case_4_input));

    }
}