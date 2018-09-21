package com.github.jarviskim.algorithm.boj.a1475_RoomNumber;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 방 번호
 * https://www.acmicpc.net/problem/1475
 */
public class RoomNumber {

    /**
     * 2018. 02. 02 추가. (성공)
     * @param stringNumber
     * @return
     */
    public static int solve2(String stringNumber) {
        int[] numbers = Arrays.stream(stringNumber.split(""))
                .map(Integer::valueOf)
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] count = new int[ 10 ];
        for ( int i = 0; i < numbers.length; i++ ) {
            int m = numbers[ i ];
            if ( m == 6 || m == 9 ) {
                m = count[ 6 ] < count[ 9 ] ? 6 : 9;
            }
            
            count[ m ]++;
        }

        return Arrays.stream(count).max().getAsInt();
    }

    /**
     * 처음 풀었던것.. 무슨 생각으로 이랬을까??
     */
    public static int solve(int n) {
        int[] numbers = new int[ 10 ];
        int length = (int) (Math.log10(n) + 1);
        int digits = 1;
        int num;
        for ( int i = 0; i < length; i++ ) {
            num = n / digits % 10;
            numbers[ num ]++;
            digits *= 10;
        }

        int max = 0;
        for ( int i = 0; i < numbers.length; i++ ) {
            int m = numbers[ i ];
            if ( i == 6 || i == 9 ) {
                m = (numbers[ 6 ] + numbers[ 9 ] + 1) / 2;
            }
            max = Math.max(max, m);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        System.out.println(solve2(n));
    }
}
