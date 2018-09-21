package com.github.jarviskim.algorithm.mailprogramming;

/**
 * 정수 배열(int array)가 주어지면 가장 큰 이어지는 원소들의 합을 구하시오. 단, 시간복잡도는 O(n).
 */
public class MaxSequenceSum {

    public static int solve(int... array) {
        int max = array[ 0 ];
        int before = array[ 0 ];
        int beforeAndSum;
        for ( int index = 1; index < array.length; index++ ) {
            beforeAndSum = before + array[ index ];
            if ( beforeAndSum < 0 || beforeAndSum < array[ index ] ) {
                before = array[ index ];
            } else if ( beforeAndSum > array[ index ] ) {
                before += array[ index ];
            }

            if ( max < before ) {
                max = before;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solve(-1, 3, -1, 5));
        System.out.println(solve(-5, -3, -1));
        System.out.println(solve(2, 4, -2, -3, 8));
    }
}
