package com.github.jarviskim.algorithm.book.apss_hanbit.fibonacci;

import java.math.BigDecimal;

/**
 * 변형된 피보나치 수열
 *
 * 원문 : https://www.hackerrank.com/challenges/fibonacci-modified
 * 자크가 번역한 문서 : https://github.com/dktechin-study/algorithm-study-by-zach/blob/master/fibonacci-modified/README.md
 *
 * DP로 풀기.
 *
 * 문제는 64bit 범위 초과.
 */
public class FibonacciModified {

    public BigDecimal solve(int tt1, int tt2, int n) {
        BigDecimal t1 = new BigDecimal(tt1);
        BigDecimal t2 = new BigDecimal(tt2);
        BigDecimal t = null;
        for ( int index = 2; index < n; index++  ) {
            t2 = t2.multiply(t2);
            t = t1.add(t2);

            t1 = t2;
            t2 = t;
        }

        return t;
    }

}
