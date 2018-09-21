package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a4948_prime_number.ChebyshevTheorem;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ChebyshevTheoremTest {

    @Test
    public void test() {
        Iterator<Integer> answers = List.of(1, 4, 3, 21, 135, 1033, 8392).iterator();

        Stream.of(1, 10, 13, 100, 1000, 10000, 100000)
                .forEach(number -> assertEquals(answers.next().intValue(), ChebyshevTheorem.solve(number)));
    }
}
