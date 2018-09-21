package com.github.jarviskim.algorithm.boj.a1005_AcmCraft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * ACM Craft
 * https://www.acmicpc.net/problem/1005
 *
 * max(m[ W ][ ]) + time = W를 건물을 짓는 최소 시간
 *
 * 시간초과.... 뭐지..재귀 호출하면 너무 느린가..
 *
 */
public class AcmCraft {

    /**
     * 2018. 02. 02 추가
     *
     * DP로 품
     *
     */
    public static int solve2(boolean[][] map, int[] buildingTimes, int w) {
        int[] times = new int[ buildingTimes.length ];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(w);

        while ( !deque.isEmpty() ) {
            int number = deque.getFirst();

            if ( times[ number ] == 0 ) {
                for ( int pos = 1; pos < map[ number ].length; pos++ ) {
                    if ( map[ number ][ pos ] ) {
                        deque.push(pos);
                    }
                }
                times[ number ] = -1;
            } else {
                deque.pop();
                if ( times[ number ] == -1 ) {
                    int max = 0;
                    for ( int pos = 1; pos < map[ number ].length; pos++ ) {
                        if ( map[ number ][ pos ] ) {
                            max = Math.max(max, times[ pos ]);
                        }
                    }

                    times[ number ] = max + buildingTimes[ number ];
                }
            }
        }

        return times[ w ];
    }

    /**
     *
     * max(m[ W ][ ]) + time = W를 건물을 짓는 최소 시간
     * 시간초과.... 뭐지..재귀 호출하면 너무 느린가..
     * (처음 작성했던 코)
     */
    public static int solve(int[][] map, int[] times, int w) {
        int max = 0;
        for ( int index = 0; index < map[ w ].length; index++ ) {
            if ( map[ w ][ index ] > 0 ) {
                int result = solve(map, times, index);
                max = Math.max(result, max);
            }
        }

        return max + times[ w ];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();

        for ( int i = 0; i < testCount; i++ ) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] times = new int[ n + 1 ];
            boolean[][] map = new boolean[ n + 1 ][ n + 1 ];

            for ( int timeIndex = 1; timeIndex <= n; timeIndex++ ) {
                times[ timeIndex ] = scanner.nextInt();
            }

            int a, b;
            for ( int kIndex = 0; kIndex < k; kIndex++ ) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                map[ b  ][ a  ] = true;
            }
            int w = scanner.nextInt();
            System.out.println(solve2(map, times, w));
        }
    }

}
