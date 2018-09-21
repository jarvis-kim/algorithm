package com.github.jarviskim.algorithm.book.apss_hanbit.propagation;

import java.util.Arrays;

public class SelfPropagationOfBook {

    static final int MAX = 100;

    int n;
    int splitSize;
    int[][] dna = new int[ 2 ][ MAX ];

    public SelfPropagationOfBook(int n, int[] data) {
        this.n = n;
        dna[ 0 ] = Arrays.copyOf(data, data.length);
    }

    public void solve() {
        int flag = 0;
        int i, j;
        boolean notComplete = true;
        splitSize = -1;

        while ( notComplete ) {
            dna[ 1 - flag ][ n - 2 ] = dna[ flag ][ n - 1 ];

            for ( i = n - 4; i >= 0; i -= 2 ) {
                dna[ 1 - flag ][ i ] = dna[ flag ][ i + 1 ] - dna[ 1 - flag ][ i + 2 ];
            }

            j = i + 2;
            j = 1 - j;

            dna[ 1 - flag ][ j ] = dna[ flag ][ 0 ] - dna[ 1 - flag ][ 1 - j ];

            for ( i = j + 2; i < n; i += 2 ) {
                dna[ 1 - flag ][ i ] = dna[ flag ][ i - 1 ] - dna[ 1 - flag ][ i - 2 ];
            }

            splitSize++;
            flag = 1 - flag;

            for ( i = 0; i < n; i++ ) {
                System.out.printf("%2d", dna[ flag ][ i ]);
                if ( dna[ flag ][ i ] < 0 ) {
                    notComplete = false;
                }
            }

            System.out.println();
        }

        if ( splitSize == 0 ) {
            splitSize = -1;
        }

        System.out.println("=============================");
        System.out.printf("%d회 분할\n\n", splitSize);
    }

    public static void main(String[] args) {
        SelfPropagationOfBook selfPropagation = new SelfPropagationOfBook(5, new int[] { 1, 3, 0, 3, 0 });
        selfPropagation.solve();

        SelfPropagationOfBook selfPropagation2 = new SelfPropagationOfBook(5, new int[] { 3, -2, -1, 5, 5 });
        selfPropagation2.solve();

        SelfPropagationOfBook selfPropagation3 = new SelfPropagationOfBook(5, new int[] { 4, 1, 6, 0, 3 });
        selfPropagation3.solve();
    }
}
