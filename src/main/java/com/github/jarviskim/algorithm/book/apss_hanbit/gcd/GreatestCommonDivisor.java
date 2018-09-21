package com.github.jarviskim.algorithm.book.apss_hanbit.gcd;

public class GreatestCommonDivisor {

    public static int gcd(int value1, int value2) {
        if ( value1 == 0 ) {
            return value2;
        }

        if ( value1 == 1 ) {
            return -1;
        }

        return gcd(value2 % value1, value1);
    }

    public static final void main(String[] args) {
        System.out.println(gcd(80, 100));
        System.out.println(gcd(12, 36));
        System.out.println(gcd(12, 35));
    }
}
