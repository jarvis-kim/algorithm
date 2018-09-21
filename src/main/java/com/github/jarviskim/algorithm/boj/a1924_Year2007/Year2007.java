package com.github.jarviskim.algorithm.boj.a1924_Year2007;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 2007년
 * https://www.acmicpc.net/problem/1924
 */
public class Year2007 {

    static int YEAR = 2007;

    private static String[] DAY_OF_MONTH = new String[] { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

    public static String solve(int month, int day) {
        LocalDate date = LocalDate.of(YEAR, month, day);
        return DAY_OF_MONTH[ date.getDayOfWeek().getValue() - 1 ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int dayOfMonth = scanner.nextInt();
        System.out.println(solve(month, dayOfMonth));
    }
}
