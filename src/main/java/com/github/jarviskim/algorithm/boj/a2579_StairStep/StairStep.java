package com.github.jarviskim.algorithm.boj.a2579_StairStep;

import java.util.Scanner;

/**
 * 계단 오르기
 * https://www.acmicpc.net/problem/2579
 * <p>
 */
public class StairStep {

    /**
     *
     * 점화식 : d[ i ] = max(d[ i - 1],d[ i - 2]) + arr[ i ]
     *
     * d1은 한칸을 밟는 것
     * d2는 두칸을 밟는 것
     *
     * d2는 한칸에서 왔는듯 두칸에서왔는 연속 세 계단을 밟지 않는다.
     *
     * d1는 d1[ seq - 1] 은 무조건 한칸 전에 온것이므로 d2의 한칸전밖에 답이 없다.
     *
     * @param stair
     * @return
     */
    public static int solveByDynamic(int[] stair) {
        int n = stair.length;

        int[] d1 = new int[ n + 1 ];
        int[] d2 = new int[ n + 1 ];

        d1[ 1 ] = d2[ 1 ] = stair[ 0 ];

        for ( int index = 1, seq = 2; index < stair.length; index++, seq++ ) {
            d1[ seq ] = d2[ seq - 1 ] + stair[ index ];
            d2[ seq ] = Math.max(d1[ seq - 2 ], d2[ seq - 2 ]) + stair[ index ];
        }

        return Math.max(d1[ n ], d2[ n ]);
    }

    private final static int MIN = -9999;

    /**
     * 시간초과..
     * 심지어 맞지도 않음..
     *
     * 실패의 기록물로 남겨 놓음.
     */
    public static int solveByRecursive(int[] stair, int idx, int jump) {
        if ( idx == 0 ) {
            return stair[ idx ];
        }
        if ( idx < 0 ) {
            return MIN;
        }

        int jump1 = MIN;
        if ( jump != 1 ) {
            jump1 = solveByRecursive(stair, idx - 1, 1);
        }
        int jump2 = solveByRecursive(stair, idx - 2, 2);

        return Math.max(jump1, jump2) + stair[ idx ];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[ n ];

        for ( int index = 0; index < n; index++ ) {
            inputs[ index ] = scanner.nextInt();
        }

        System.out.println(solveByDynamic(inputs));
    }
}

