package com.github.jarviskim.algorithm.boj.a2981_Inspection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * 검문
 *
 * https://www.acmicpc.net/problem/2981
 */
public class Inspection {

    public static long[] solve(long... numbers) {
        if ( numbers.length < 2 ) {
            throw new IllegalArgumentException("numbers의 갯수는 2개 이상입니다. ");
        }
        numbers = LongStream.of(numbers).sorted().toArray();

        List<Long> num = new ArrayList<>();
        Arrays.stream(numbers).reduce((left, right) -> {
            num.add(Math.abs(left - right));
            return right;
        });

        long g = num.stream().reduce((left, right) -> gcm(left, right)).get();
        List<Long> cm = new ArrayList<>();

        long srqt = (long) Math.sqrt(g);
        for ( long i = 2; i <= srqt; i++ ) {
            if ( g % i == 0 ) {
                cm.add(i);
            }
        }
        cm.add(g);

        return cm.stream().sorted().mapToLong(value -> value).toArray();
    }

    static long gcm(long a, long b) {
        long aa = a, bb = b;
        long tmp;
        while ( aa % bb != 0 ) {
            tmp = aa;
            aa = bb % aa;
            bb = tmp;
        }

        return bb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long data[] = new long[ n ];
        for ( int i = 0; i < n; i++ ) {
            data[ i ] = scanner.nextLong();
        }

        long[] result = solve(data);

        for ( long r : result ) {
            System.out.print(r + " ");
        }

        System.out.println();
    }

}
