package com.github.jarviskim.algorithm.boj.a9019_DSLR;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제 : DSLR
 * 출처 : https://www.acmicpc.net/problem/9019
 */
public class DSLR {

    private static final int MAX = 9999;

    private static final int MIN = 0;

    private static final int N_COUNT = 1000;

    public String solve(int n, int to) {
        Queue<Integer> queue = new LinkedList<>();
        char[] commands = new char[ MAX + 1 ];
        int[] via = new int[ MAX + 1 ];
        via[ n ] = -1;
        commands[ n ] = '1';
        queue.add(n);

        int current;
        int next;
        while ( !queue.isEmpty() ) {
            current = queue.poll();
            if ( current == to ) {
                break;
            }

            next = operateD(current);
            if ( commands[ next ] == 0 ) {
                queue.add(next);
                via[ next ] = current;
                commands[ next ] = 'D';
            }

            next = operateS(current);
            if ( commands[ next ] == 0 ) {
                queue.add(next);
                via[ next ] = current;
                commands[ next ] = 'S';
            }

            next = operateL(current);
            if ( commands[ next ] == 0 ) {
                queue.add(next);
                via[ next ] = current;
                commands[ next ] = 'L';
            }

            next = operateR(current);
            if ( commands[ next ] == 0 ) {
                queue.add(next);
                via[ next ] = current;
                commands[ next ] = 'R';
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int trace = to;
        while ( trace != n ) {
            stringBuilder.append(commands[ trace ]);
            trace = via[ trace ];
        }

        return stringBuilder.reverse().toString();
    }

    private int operateD(int n) {
        return n * 2 > MAX ? (n * 2) % (MAX + 1) : n * 2;
    }

    private int operateS(int n) {
        return n - 1 < MIN ? MAX : n - 1;
    }

    private int operateL(int n) {
        return (n % N_COUNT) * 10 + (n / N_COUNT);
    }

    private int operateR(int n) {
        return (n / 10) + ((n % 10) * N_COUNT);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        int from, to;
        DSLR dslr = new DSLR();
        for ( int count = 0; count < t; count++ ) {
            from = scanner.nextInt();
            to = scanner.nextInt();
            System.out.println(dslr.solve(from, to));
        }
    }
}
