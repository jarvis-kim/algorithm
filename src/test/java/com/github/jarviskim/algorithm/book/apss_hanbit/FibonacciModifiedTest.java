package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.fibonacci.FibonacciModified;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciModifiedTest {

    @Test
    public void test() {
        FibonacciModified fibonacciModified = new FibonacciModified();
        assertEquals("5", fibonacciModified.solve(0, 1, 5).toString());
        System.out.println(fibonacciModified.solve(0, 1, 10).toString());
    }
}
