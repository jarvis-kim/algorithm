package com.github.jarviskim.algorithm.book.apss_hanbit.propagation;

import java.util.Arrays;

public class SelfPropagation {

    private int[] dna;

    public SelfPropagation(int... dna) {
        this.dna = dna;
    }

    public int[][] proliferate(int n) {
        int dnaCount = this.dna.length;
        int[] dna =Arrays.copyOf(this.dna, dnaCount);
        int[] next;
        int[][] transition = new int[ n + 1 ][];
        transition[ 0 ] = dna;
        for ( int count = 0; count < n; count++ ) {
            next = new int[ dna.length ];
            next[ 0 ] = dna[ 0 ] + dna[ 1 ];
            for ( int index = 1; index < dna.length; index++ ) {
                next[ index ] = dna[ index - 1 ];
                if ( index + 1 < dna.length ) {
                    next[ index ] += dna[ index + 1 ];
                }
            }
            transition[ count + 1 ] = next;
            dna = next;
        }

        return transition;
    }

    public static final void main(String[] args) {
        SelfPropagation selfPropagation = new SelfPropagation(0, 0, 1, 0, 0);
        int[][] dna = selfPropagation.proliferate(4);
        for ( int y = 0; y < dna.length; y++ ) {
            for ( int x = 0; x < dna[ y ].length; x++ ) {
                System.out.printf("%3d", dna[ y ][ x ]);
            }
            System.out.println();
        }

    }
}
