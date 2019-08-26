package com.github.jarviskim.algorithm.mailprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Quiz20190825Test {

    @Test
    public void resolve() {
        Quiz20190825 quiz = new Quiz20190825();
        int[] case1 = {1, 2, 3, 4, 4};
        int expected1 = 4;

        int[] case2 = {1, 2, 3, 4, 2};
        int expected2 = 2;

        int[] case3 = {1, 2, 3, 4, 3, 5};
        int expected3 = 3;

        Assert.assertEquals(expected1, quiz.resolve(case1));
        Assert.assertEquals(expected2, quiz.resolve(case2));
        Assert.assertEquals(expected3, quiz.resolve(case3));
    }
}
