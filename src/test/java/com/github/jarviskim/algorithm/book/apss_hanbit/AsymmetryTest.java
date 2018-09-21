package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.asymmetry.Asymmetry;
import org.junit.Assert;
import org.junit.Test;

public class AsymmetryTest {

    @Test
    public void test() {
        /* Case 1 : n = 4 */
        Asymmetry asymmetry = new Asymmetry();
        char[][] result1 = asymmetry.asymmetry('A', 'B', 'C', 'D');
        char[][] answer1 = {
                { 'A', 'B', 'C', 'D' },
                { 'B', 'A', 'D', 'C' },
                { 'C', 'D', 'A', 'B' },
                { 'D', 'C', 'B', 'A' }
        };

        for ( int index = 0; index < result1.length; index++ ) {
            Assert.assertArrayEquals(answer1[ index ], result1[ index ]);
        }

        /* Case 2 : n = 8 */
        asymmetry = new Asymmetry();
        char[][] result2 = asymmetry.asymmetry('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
        char[][] answer2 = {
                { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' },
                { 'B', 'A', 'D', 'C', 'F', 'E', 'H', 'G' },
                { 'C', 'D', 'A', 'B', 'G', 'H', 'E', 'F' },
                { 'D', 'C', 'B', 'A', 'H', 'G', 'F', 'E' },
                { 'E', 'F', 'G', 'H', 'A', 'B', 'C', 'D' },
                { 'F', 'E', 'H', 'G', 'B', 'A', 'D', 'C' },
                { 'G', 'H', 'E', 'F', 'C', 'D', 'A', 'B' },
                { 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' }
        };

        for ( int index = 0; index < result2.length; index++ ) {
            Assert.assertArrayEquals(answer2[ index ], result2[ index ]);
        }

    }

}
