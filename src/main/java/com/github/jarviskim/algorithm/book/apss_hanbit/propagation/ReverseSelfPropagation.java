package com.github.jarviskim.algorithm.book.apss_hanbit.propagation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReverseSelfPropagation {

    public static int[][] reverse(int... dna) {
        int[] original = dna;
        int dnaCount = dna.length;
        int[] next;
        dna = Arrays.copyOf(dna, dnaCount);
        List<int[]> transition = new ArrayList<>();
        while ( next(dna) ) {
            next = new int[ dnaCount ];
            next[ 0 ] = dna[ 0 ];
            if ( dna[ 0 ] >= 0 && dna[ 0 ] <= dna[ 1 ] ) {
                next[ 1 ] = dna[ 1 ] - dna[ 0 ];
            } else if ( dna[ 0 ] > dna[ 1 ] ) {
                next[ 1 ] = dna[ 0 ];
                next[ 0 ] = 0;
            }
            for ( int index = 1; index < dna.length - 1; index++ ) {
                if ( dna[ index ] > 0 ) {
                    next[ index + 1 ] = next[ index ];
                    next[ index ] = 0;
                } else if ( dna[ index ] == 0 ) {
                    next[ index + 1 ] = dna[ index + 1 ] - next[ index ];
                }
            }
            dna = next;
            transition.add(dna);
        }

        int[][] result = new int[ transition.size() + 1 ][];
        result[ 0 ] = original;
        Iterator<int[]> iterator = transition.iterator();
        int count = 1;
        while ( iterator.hasNext() ) {
            result[ count++ ] = iterator.next();
        }

        return result;
    }

    private static boolean next(int... dna) {
        for ( int d : dna ) {
            if ( d < 0 ) {
                return false;
            }
        }
        return true;
    }

    public static final void main(String[] args) {
        int[][] dna = ReverseSelfPropagation.reverse(1, 3, 0, 3, 0);
        print(dna);

        dna = ReverseSelfPropagation.reverse(4 , 1,  6,  0,  3);
        print(dna);

        dna = ReverseSelfPropagation.reverse(1, 2, 3, 4, 5);
        print(dna);
    }

    public static void print(int[][] dna) {
        for ( int y = 0; y < dna.length; y++ ) {
            for ( int x = 0; x < dna[ y ].length; x++ ) {
                System.out.printf("%3d", dna[ y ][ x ]);
            }
            System.out.println();
        }
        System.out.println("===============================");
        System.out.printf("%d회 분할\n\n", dna.length - 2);
    }

}
