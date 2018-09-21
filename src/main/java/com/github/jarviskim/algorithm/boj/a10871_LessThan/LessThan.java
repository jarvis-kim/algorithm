package com.github.jarviskim.algorithm.boj.a10871_LessThan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * X 보다 작은 수
 *
 * https://www.acmicpc.net/problem/10871
 */
public class LessThan {

    public static int[] solve(int[] a, int x) {
        List<Integer> result = new ArrayList<>();
        for ( int i : a ) {
            if ( i < x ) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(v -> v).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            a[ i ] = scanner.nextInt();
        }

        int[] result = solve(a, x);
        for ( int i : result ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
