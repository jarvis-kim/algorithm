package com.github.jarviskim.algorithm.book.apss_hanbit.irreducible;

/**
 * 분할정복법으로 기약분수 구하기
 * 입력
 * n : n값 이하의 기약분수 전부 구하기
 *
 * 궁금점 : 분할정복 챕터에 기약분수 문제가 있는데, 이 문제를 분할정복법으로 풀수 있나??
 *
 * 용어
 * 분모 : denominator
 * 분자 : molecule
 */
public class IrreducibleFunction {

    public int solve(int n) {
        int count = 0;
        for ( int denominator = 1; denominator <= n; denominator++ ) {
            for ( int molecule = 0; molecule <= denominator; molecule++ ) {
                if ( gcd(molecule, denominator) == 1 ) {
                    count++;
                    System.out.println("찾은 기약분수 : " + molecule + "/" + denominator);
                }
            }
        }

        return count;
    }

    public int gcd(int a, int b) {
        if ( a == 0 ) {
            return b;
        }

        if ( a == 1 ) {
            return 1;
        }

        return gcd(b % a, a);
    }

}
