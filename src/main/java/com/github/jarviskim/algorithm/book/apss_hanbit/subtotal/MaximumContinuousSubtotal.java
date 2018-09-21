package com.github.jarviskim.algorithm.book.apss_hanbit.subtotal;

/**
 * 최대 부분 연속 집합의 합.
 *
 * 전략 : 솔직히 전수 조사 아니면 모르겠다...
 * 이보다 더 나은 방법은 문제를 풀고, 토론 또는 책을 봐야하겠다.
 * 부분 배열들의 합을 구한다. 그중 가증 큰값이 최대합이다.
 * 내 계산으로는 이식은 n2정도 일것같은데, 토론 시간에 논의해봐야겠다.
 *
 * 좀더 나은 방법이 있을거같은데.. 모르겠다...하아...
 *
 */
public class MaximumContinuousSubtotal {

    private int[][] subSequences;
    private int max;
    public MaximumContinuousSubtotal(int... sequence) {
        subSequences = new int[ sequence.length ][ sequence.length ];

        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < sequence.length; i++ ) {
            int before = 0;
            subSequences[ i ][ i ] = sequence[ i ];
            for ( int j = i; j < sequence.length; j++ ) {
                before = subSequences[ i ][ j ] = before + sequence[ j ];
                if ( subSequences[ i ][ j ] > max ) {
                    max = subSequences[ i ][ j ];
                }
            }
        }

        this.max = max;
    }

    public int maxSubtotal() {
        return max;
    }

}
