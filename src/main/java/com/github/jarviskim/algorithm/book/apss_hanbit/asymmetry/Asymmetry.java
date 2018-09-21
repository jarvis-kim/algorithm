package com.github.jarviskim.algorithm.book.apss_hanbit.asymmetry;

import java.util.Arrays;

/**
 * output :
 * A B C D
 * B A D C
 * C D A B
 * D C B A
 *
 *  |-----------|
 *  |  1  |  2  |
 *  |-----|-----|
 *  |  3  |  4  |
 *  |-----------|
 *
 * 나의 전략 : 분할정복법 이용
 * n값을 기준으로 반을 나눈다. 예를들어 3영역에선 2의 영역을 복사하고, 4의 영역에서 1의 영역을 복사한다.
 * 그런데 해당 영역이 초기에 크다면 분할하여 작은 것부터 처리한다. (사실 그냥 밑에서 부터 해도 될듯함...지만 배귀를 이용한 연습)
 *
 */

public class Asymmetry {

    public char[][] asymmetry(char... inputs) {
        int n = inputs.length;
        char[][] map = new char[ n ][];
        for ( int index = 0; index < n; index++ ) {
            map[ index ] = new char[ n ];
        }
        map[ 0 ] = Arrays.copyOf(inputs, inputs.length);

        asymmetry(map, n, 0);

        return map;
    }

    public void asymmetry(char[][] map, int y, int x) {
        if ( y == 1 ) {
            return;
        }

        /* 왼쪽에 대해서 */
        asymmetry(map, y / 2, x);

        /* 오른쪽에 대해서 */
        asymmetry(map, y / 2, x + (y / 2));

        /* 외쪽에 있는걸 카피 */
        copySquare(map, y, x, x + (y / 2));
        print(map);

        /* 오른쪽에 있는걸 카피 */
        copySquare(map, y, x + (y / 2), x);
        print(map);
    }

    private void copySquare(char[][] map, int y, int srcX, int destX) {
        for ( int destY = y - 1, srcY = (y / 2) - 1; destY > (y / 2) - 1; destY--, srcY-- ) {
            System.arraycopy(map[ srcY ], srcX , map[ destY ], destX , y / 2);
        }
    }

    private void print(char[][] map) {
        for ( int i = 0; i < map.length; i++ ) {
            for ( int j = 0; j < map[ i ].length; j++ ) {
                System.out.print(map[ i ][ j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n-------------------------------");
    }
}
