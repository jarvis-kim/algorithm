package com.github.jarviskim.algorithm.boj.a6064_KaingCalendar;

import java.util.Scanner;

/**
 * 카잉 달력
 * https://www.acmicpc.net/problem/6064
 *
 * 뭔가 패턴이 있을듯......O(M x N)
 * 아......이걸로 하면 시간초과다.......
 *
 * 보류...
 */
public class KaingCalendar {

    public static int solve(int m, int n, int x, int y) {
        if ( x == 1 && y == 1 ) {
            return 1;
        }
        int count = 1;
        int xx = 1;
        int yy = 1;

        while ( !(m == xx && n == yy) ) {
            count++;
            xx = xx % m + 1;
            yy = yy % n + 1;
            if ( xx == x && yy == y ) {
                return count;
            }

        }

        return m == xx && n == yy ? -1 : count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseCount = scanner.nextInt();

        for ( int i = 0; i < caseCount; i++ ) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(solve(m, n, x, y));
        }
    }

}
