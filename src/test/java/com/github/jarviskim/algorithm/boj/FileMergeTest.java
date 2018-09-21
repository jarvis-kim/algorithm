package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a11066_FileMerge.FileMerge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class FileMergeTest {

    @Test
    public void test() {
        Assert.assertEquals(300, FileMerge.solve(40, 30, 30, 50));
        Assert.assertEquals(864, FileMerge.solve(1, 21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32));
    }

    static final int MAX = 500;
    static final int FILE_SIZE = 10000;
    int[] data;
    @Before
    public void initData() {
        data = new int[ MAX ];
        Random random = new Random();
        for ( int i = 0; i < MAX; i++ ) {
            data[ i ] = random.nextInt(FILE_SIZE - 1) + 1;
        }
    }

    @Test(timeout = 2000L)
    public void performanceTest() {
        System.out.println(FileMerge.solve(data));
    }
}
