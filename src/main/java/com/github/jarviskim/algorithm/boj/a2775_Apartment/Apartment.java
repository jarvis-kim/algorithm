package com.github.jarviskim.algorithm.boj.a2775_Apartment;

import java.util.Scanner;

/**
 * 부녀회장이 될테야
 * https://www.acmicpc.net/problem/2775
 */
public class Apartment {

    public static int solve(int floor, int roomNumber) {
        int[] rooms = new int[ roomNumber + 1 ];
        for ( int i = 1; i <= roomNumber; i++ ) {
            rooms[ i ] = i;
        }

        for ( int f = 1; f <= floor; f++ ) {
            for ( int rn = 1; rn <= roomNumber; rn++ ) {
                rooms[ rn ] = rooms[ rn - 1 ] + rooms[ rn ];
            }
        }

        return rooms[ roomNumber ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for ( int i = 0; i < t; i++ ) {
            int floor = scanner.nextInt();
            int roomNumber = scanner.nextInt();
            System.out.println(solve(floor, roomNumber));
        }
    }
}
