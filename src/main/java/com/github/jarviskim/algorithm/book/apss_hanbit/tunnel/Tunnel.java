package com.github.jarviskim.algorithm.book.apss_hanbit.tunnel;

/**
 * 문제) 여러 터널이 있다. 이 터널 중 구간을 지정하여 그 구간의 가장 작은 높이를 구하는 문제.
 * 이 문제는 터널마다 여러 구간을 구한다.
 *
 * 전략 1) 그냥 무조건 그 구간에서 최소 값 찾기
 * 전략 2) 동적계획법
 * 전략 3) 분할정복 + 메모이제이션
 *
 * input의 케이스를 보아 분할정복 + 메모이제이션로 하겠다.
 *
 *
 */
public class Tunnel {

    private int[] heights;

    private int[][] memorial;

    public Tunnel(int... heights) {
        this.heights = heights;
        int n = heights.length;
        this.memorial = new int[ n ][ n ];
        for ( int index = 0; index < this.heights.length; index++ ) {
            this.memorial[ index ][ index ] = this.heights[ index ];
        }
    }

    public int minimumHeight(int start, int end) {
        if ( memorial[ start - 1 ][ end - 1 ] != 0 ) {
            return memorial[ start - 1 ][ end - 1 ];
        }

        int result = minimumHeight(start + 1, end);
        memorial[ start - 1 ][ end - 1 ] = Math.min(heights[ start - 1 ], result);
        printMemory();

        return memorial[ start - 1 ][ end - 1 ];
    }

    public void printMemory() {
        for ( int i = 0; i < memorial.length; i++ ) {
            for ( int j = 0; j < memorial[ i ].length; j++ ) {
                System.out.printf("%4d | ", memorial[ i ][ j ]);
            }
            System.out.println();
        }

        for ( int i = 0; i < heights.length; i++ ) {
            System.out.print("=======");
        }
        System.out.println();
    }
}

