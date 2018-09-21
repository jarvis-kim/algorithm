package com.github.jarviskim.algorithm.book.apss_hanbit.travel;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 배낭 여행
 * (외판원 문제를 배낭여행이라고 바꾸다니 -_-..)
 *
 *
 *
 */
public class Travel {

    public int minimumCost(int[][] map) {
        int n = map.length;
        int[] via = new int[ n ];
        for ( int index = 0; index < via.length; index++ ) {
            via[ index ] = 0;
        }
        int[] degree = new int[ n ];
        degree[ 0 ] = 0;
        for ( int index = 1; index < degree.length; index++ ) {
            degree[ index ] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();


        while ( queue.isEmpty() ) {
            Integer vertex = queue.poll();
            for ( int to = 0; to < n; to++ ) {
                if ( vertex != to && map[ vertex ][ to ] > 0 ) {
                    if ( degree[ vertex ] + map[ vertex ][ to ] < degree[ to ] ) {
                        queue.add(to);
                        degree[ to ] = degree[ vertex ] + map[ vertex ][ to ];
                        via[ to ] = vertex;
                    }
                }
            }
        }

        return 0;
    }
}
