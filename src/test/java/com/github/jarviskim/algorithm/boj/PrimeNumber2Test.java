package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2581_prime_number2.PrimeNumber2;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimeNumber2Test {

    @Test
    public void test() {
        List<Integer> primeNumbers =  PrimeNumber2.result(60, 100);
        primeNumbers.stream()
                .min(Integer::compareTo)
                .ifPresent(value -> assertEquals(61, value.intValue()));

        int sum = primeNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        assertEquals(620, sum);


    }

    @Test(timeout = 1000)
    public void test2() {
        List<Integer> primeNumbers =  PrimeNumber2.result(1, 10000);
        primeNumbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(value -> assertEquals(2, value));
    }
}
