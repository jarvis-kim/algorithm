package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.tiling.Tiling;
import org.junit.Assert;
import org.junit.Test;

public class TilingTest {

    @Test
    public void test() {
        Tiling tiling = new Tiling();
        Assert.assertEquals(171, tiling.solve(8));

    }
}
