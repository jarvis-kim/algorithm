package com.github.jarviskim.algorithm.book.apss_hanbit.move;

/**
 * 문제. 여러개의 주머니 안에 동전들이 갯수가 똑같아 지려면 동전이 몇번을 이동되어야하는가?
 *
 * 전략. 주머니 안에 동전 갯수의 평균을 구해 평균보다 낮은 것들을 계산한다.
 */
public class MoveMoney {

    public int solve(int... pockets) {
        int sum = 0;
        for ( int pocket : pockets ) {
            sum += pocket;
        }

        int avg = sum / pockets.length;

        int count = 0;
        for ( int index = 0; index < pockets.length; index++ ) {
            if ( pockets[ index ] < avg ) {
                count += avg - pockets[ index ];
            }
        }

        return count;
    }
}
