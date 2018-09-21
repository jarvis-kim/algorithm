package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.block.StackBlock;
import org.junit.Test;

public class StackBlockTest {

    @Test
    public void test() {
        int[][] map = {
                { 3, 2, 5, 1, 3, 2 },
                { 4, 1, 4, 2, 3, 2 },
                { 3, 3, 1, 1, 2, 4 },
                { 5, 5, 1, 3, 5, 4 },
                { 4, 5, 2, 4, 1, 5 }
        };

        StackBlock stackBlock = new StackBlock(map);
        int[][] result = stackBlock.solve();

        for ( int i = 0; i < result.length; i++ ) {
            for ( int j = 0; j < result[ i ].length; j++ ) {
                System.out.printf("%3d", result[ i ][ j ]);
            }
            System.out.println();
        }

    }
}
