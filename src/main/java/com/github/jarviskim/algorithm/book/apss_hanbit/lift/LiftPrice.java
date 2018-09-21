package com.github.jarviskim.algorithm.book.apss_hanbit.lift;

/**
 *  스키장 리프트 가격
 *
 *  DP 알고리즘인데 DP로 도저히 못풀겠음....
 *
 * 일단 걍 무작정 알고리즘 고고
 */
public class LiftPrice {

    private int[] prices;

    private int n;

    public LiftPrice(int... prices) {
        this.prices = prices;
        this.n = prices.length;
        this.prices = new int[ n + 1];
        System.arraycopy(prices, 0, this.prices, 1, n);
    }

    public int min(int day) {
        if ( day == 0 ) {
            return 0;
        }
        int index = day < n ? day : n;
//        if ( 0 < day && day <= n ) {
//            return prices[ day ];
//        }

        int minSum = Integer.MAX_VALUE;
        int result;
        for (; index > 0; index-- ) {
            result = min(day - index) + prices[ index ];;
            minSum = Math.min(minSum, result);
        }

        return minSum;
    }
}