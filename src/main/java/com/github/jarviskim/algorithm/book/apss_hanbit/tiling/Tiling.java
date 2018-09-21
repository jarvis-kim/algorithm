package com.github.jarviskim.algorithm.book.apss_hanbit.tiling;

/**
 * 2 x n 타일링
 *
 * 1 x 2, 2 x 1, 2 x 2의 도형이 있음
 *
 * 타일링이 채워질 수 있는 경우의 수를 출력
 *
 * 전략
 * n = 1 일때 수는 1
 * n = 2 일때 수는 c[n - 1] + 2
 *
 * n >= 3 일때, 2 x 2, 2 x 1(두개 채움)가 두개 있으므로 c(n-2) + c(n-2)
 *             1 x 2는 c(n-1)
 *
 * n -1이나 n -2만큼 타일을 뺐을 때 전의 값을 더하면 됨
 */
public class Tiling {

    public int solve(int n) {
        int[] counts = new int[ n + 1 ];
        counts[ 1 ] = 1;
        counts[ 2 ] = counts[ 1 ] + 2;

        for ( int index = 3; index <= n; index++ ) {
            counts[ index ] = counts[ index - 1 ] + counts[ index - 2] + counts[ index - 2];
        }

        return counts[ n ];
    }

}
