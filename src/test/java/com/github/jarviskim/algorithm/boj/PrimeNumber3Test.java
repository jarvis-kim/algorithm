package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1929_prime_number.Eratos;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class PrimeNumber3Test {

    @Test(timeout = 1000)
    public void test() {
        assertArrayEquals(
                Arrays.asList(3, 5, 7, 11, 13).toArray(),
                Eratos.eratos(3, 16).toArray());
    }

    @Test(timeout = 1000)
    public void test2() {
        assertArrayEquals(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257).toArray(),
                Eratos.eratos(2, 257).toArray());
    }

    @Test(timeout = 1000)
    public void test3() {
        assertArrayEquals(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31).toArray(),
                Eratos.eratos(1, 31).toArray());
    }

}
