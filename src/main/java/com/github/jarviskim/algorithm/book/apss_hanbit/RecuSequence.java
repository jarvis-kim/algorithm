package com.github.jarviskim.algorithm.book.apss_hanbit;

public class RecuSequence {

    public static final void main(String[] args) {
        print(3, 5);
    }


    public static void print(int a, int to) {
        consolePrint(a);
        if ( a == to ) {
            return;
        }
        print(a + 1, to);
        consolePrint(a);
    }

    public static void consolePrint(int a) {
        System.out.print(a);
    }
}
