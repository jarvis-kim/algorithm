package com.github.jarviskim.algorithm.boj.a3036_ring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 링
 *
 * https://www.acmicpc.net/problem/3036
 */
public class Ring {

    public static String[] solve(int... numbers) {
        int num = numbers[ 0 ];

        List<String> list = new ArrayList<>();

        for ( int i = 1; i < numbers.length; i++ ) {
            int g = gcm(num, numbers[ i ]);
            String result = (num / g) + "/" + (numbers[ i ] / g);

            list.add(result);
        }

        return list.stream().toArray(value -> new String[ value ]);
    }


    public static int gcm(int a, int b) {
        int aa = a, bb = b;
        int tmp;
        while ( aa % bb != 0 ) {
            tmp = aa;
            aa = bb % aa;
            bb = tmp;
        }

        return bb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] data = new int[ count ];
        for ( int i = 0; i < count; i++ ) {
            data[ i ] = scanner.nextInt();
        }

        String[] result = solve(data);
        Arrays.stream(result).forEach(System.out::println);
    }
}
