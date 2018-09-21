package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.irreducible.IrreducibleFunction;
import org.junit.Assert;
import org.junit.Test;

public class IrreducibleFunctionTest {

    @Test
    public void test() {
        IrreducibleFunction irreducibleFunction = new IrreducibleFunction();
        int count = irreducibleFunction.solve(5);
        Assert.assertEquals(11, count);
        System.out.println("총  " + count + "개의 기약분수가 존재합니다.");

        System.out.println();

        count = irreducibleFunction.solve(10);
        Assert.assertEquals(33, count);
        System.out.println("총  " + count + "개의 기약분수가 존재합니다.");

        System.out.println();

        count = irreducibleFunction.solve(15);
        Assert.assertEquals(73, count);
        System.out.println("총  " + count + "개의 기약분수가 존재합니다.");
    }
}
