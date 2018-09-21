package com.github.jarviskim.algorithm.book.apss_hanbit.stair;

/**
 * 계단 오르기 게임 문제- 537p
 *
 * 문제
 *  첫번째 계단과 마지막 계단은 밟아야함.
 *  한칸또는 두칸을 넘을수 있다. 두칸을 넘을때는 중간에 계단을 밟을 수 없음.
 *  적은 횟수로 도달해야한다.
 *  마지막 계단의 점수가 가장 누적 점수가 큰 점수를 출력하라.
 *
 *  DP를 이용하여 풀이
 *
 * 전략
 *  : S = 누적 점수, M = 이동 횟수, scores = 입력 데이터
 *  S(i)는 이동 누적 횟수가 i-1과 i-2가 같을 때 -> M(i - 1) == M(i - 2) 같을 때 max( S(i -1), S(i-2)) + scores(i)
 *  S(i)는 이동 누적 횟수가 더 적은 min( M(i-1), M(i-2))의 인덱스(i-1 or i-2)의 누적 점수 + scores(i)이다.
 *
 */
public class StairStep {

    public int solve(int... scores) {
        int n = scores.length;
        int[] totalScore = new int[ n ];
        int[] moveCount = new int[ n ];

        totalScore[ 0 ] = scores[ 0 ];
        moveCount[ 0 ] = 0;

        totalScore[ 1 ] = totalScore[ 0 ] + scores[ 1 ];
        moveCount[ 1 ] = moveCount[ 0 ] + 1;

        int target;
        for ( int index = 2; index < n; index++ ) {
            if ( moveCount[ index - 1 ] == moveCount[ index - 2 ] ) {
                target = totalScore[ index - 1 ] > totalScore[ index - 2 ] ? index - 1 : index - 2;
            } else {
                target = moveCount[ index - 1 ] < moveCount[ index - 2 ] ? index - 1 : index - 2;
            }

            totalScore[ index ] = totalScore[ target ] + scores[ index ];
            moveCount[ index ] = moveCount[ target ] + 1;
        }

        return totalScore[ n - 1 ];
    }
}
