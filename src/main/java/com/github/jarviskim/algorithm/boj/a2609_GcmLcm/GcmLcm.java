package com.github.jarviskim.algorithm.boj.a2609_GcmLcm;

import java.util.Scanner;

/**
 * 최대공약수와 최소공배수
 *
 * https://www.acmicpc.net/problem/2609
 */
public class GcmLcm {

    public static class Result {
        public int gcm;
        public int lcm;

        public Result(int gcm, int lcm) {
            this.gcm = gcm;
            this.lcm = lcm;
        }
    }

    public static Result solve(int a, int b) {
        int aa = a, bb = b;
        int tmp;
        while ( aa % bb != 0 ) {
            tmp = aa;
            aa = bb % aa;
            bb = tmp;
        }

        Result result = new Result(bb, a * b / bb);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Result result = solve(a, b);
        
        System.out.println(result.gcm);
        System.out.println(result.lcm);
    }
}
