package com.github.jarviskim.algorithm.book.apss_hanbit.block;

import java.util.HashSet;
import java.util.Objects;

/**
 * 욕심장이 기법을 이용한 블록 쌓기
 * 11장 4섹션
 */
public class StackBlock {
//    int[][] map = {
//            { 3, 2, 5, 1, 3, 2 },
//            { 4, 1, 4, 2, 3, 2 },
//            { 3, 3, 1, 1, 2, 4 },
//            { 5, 5, 1, 3, 5, 4 },
//            { 4, 5, 2, 4, 1, 5 }
//    };

    private int m;

    private int n;

    private HashSet<Block> blocks = new HashSet<>();

    private int[][] map;

    private int[][] blockMap;

    private boolean solved = false;

    public StackBlock(int[][] map) {
        this.map = map;
        this.n = map.length;
        this.m = map[ 0 ].length;
        blockMap = new int[ n ][ m ];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                blockMap[ i ][ j ] = 0;
            }
        }
    }

    public int[][] solve() {
        solve(0, 0, 1);
        return blockMap;
    }

    boolean solve(int x, int y, int count) {
        if ( m * n / 2 == blocks.size() ) {
            return true;
        }
        if ( x >= m ) {
            return solve(0, y + 1, count);
        }
        if ( y >= n ) {
            return false;
        }

        if ( blockMap[ y ][ x ] > 0 ) {
            return solve(x + 1, y, count);
        }

        Block rowBlock = null;
        boolean rowSolved = false;
        if ( (rowBlock = canPutRowBlock(x, y)) != null ) {
            rowBlock.putBlock(x, y, count);
            print(x, y, count);
            if ( !(rowSolved = solve(x + 2, y, count + 1)) ) {
                rowBlock.clearBlock(x, y);
                print(x, y, count);
            }
        }

        Block columnBlock = null;
        boolean columnSolved = false;
        if ( !rowSolved && (columnBlock = canPutColumnBlock(x, y)) != null ) {
            columnBlock.putBlock(x, y, count);
            print(x, y, count);
            if ( !(columnSolved = solve(x + 1, y, count + 1)) ) {
                columnBlock.clearBlock(x, y);
                print(x, y, count);
            }
        }

        return rowSolved || columnSolved;
    }

    private void print(int x, int y, int count) {
        System.out.println("=========================");
        System.out.printf("x : %2d,  y : %2d,  count : %2d", x, y, count);
        System.out.println("\n");

        for ( int i = 0; i < blockMap.length; i++ ) {
            for ( int j = 0; j < blockMap[ i ].length; j++ ) {
                System.out.printf("%3d", blockMap[ i ][ j ]);
            }
            System.out.println();
        }

        System.out.println("=========================\n");
    }

    private Block canPutRowBlock(int x, int y) {
        if ( x + 1 < blockMap[ y ].length
                && blockMap[ y ][ x ] == 0 && blockMap[ y ][ x + 1 ] == 0 ) {
            Block block = new RowBlock(map[ y ][ x ], map[ y ][ x + 1 ]);
            if ( !blocks.contains(block) ) {
                return block;
            }
        }

        return null;
    }

    private Block canPutColumnBlock(int x, int y) {
        if ( y + 1 < blockMap.length
                && blockMap[ y ][ x ] == 0 && blockMap[ y + 1 ][ x ] == 0 ) {
            Block block = new ColumnBlock(map[ y ][ x ], map[ y + 1][ x ]);
            if ( !blocks.contains(block) ) {
                return block;
            }
        }
        return null;
    }

    abstract class Block {
        int value1;
        int value2;

        public Block(int value1, int value2) {
            this.value1 = Math.min(value1, value2);
            this.value2 = Math.max(value1, value2);
        }

        abstract boolean putBlock(int x, int y, int count);

        abstract void clearBlock(int x, int y);

        @Override
        public boolean equals(Object o) {
            if ( this == o ) return true;
            if ( !(o instanceof Block) ) return false;
            Block block = (Block) o;
            return value1 == block.value1 &&
                    value2 == block.value2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value1, value2);
        }

    }

    class RowBlock extends Block {

        public RowBlock(int value1, int value2) {
            super(value1, value2);
        }

        @Override
        boolean putBlock(int x, int y, int count) {
            blockMap[ y ][ x ] = count;
            blockMap[ y ][ x + 1 ] = count;
            blocks.add(this);
            return false;
        }

        @Override
        void clearBlock(int x, int y) {
            blockMap[ y ][ x ] = 0;
            blockMap[ y ][ x + 1 ] = 0;
            blocks.remove(this);
        }

    }

    class ColumnBlock extends Block {

        public ColumnBlock(int value1, int value2) {
            super(value1, value2);
        }

        @Override
        boolean putBlock(int x, int y, int count) {
            blockMap[ y ][ x ] = count;
            blockMap[ y + 1 ][ x ] = count;
            blocks.add(this);
            return false;
        }

        @Override
        void clearBlock(int x, int y) {
            blockMap[ y ][ x ] = 0;
            blockMap[ y + 1 ][ x ] = 0;
            blocks.remove(this);
        }
    }


}
