package com.github.jarviskim.algorithm.boj.a2455_BrainTrain;

import java.util.Scanner;

/**
 * 지능형 기차
 *
 * https://www.acmicpc.net/problem/2455
 */
public class BrainTrain {

    static class Pair<F, S> {
        F first;
        S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int solve(Pair<Integer, Integer>... numbers) {
        int maximum = 0;
        int current = 0;
        for ( Pair<Integer, Integer> number : numbers ) {
            current  -= number.first;
            current += number.second;
            maximum = Math.max(current, maximum);
        }

        return maximum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pair[] data = new Pair[ 4 ];
        for ( int i = 0; i < 4; i++ ) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            data[ i ] = new Pair(a, b);
        }
        System.out.println(solve(data));
    }
}
