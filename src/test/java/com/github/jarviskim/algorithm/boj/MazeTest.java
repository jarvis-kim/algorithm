package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2178_Maze.Maze;
import org.junit.Assert;
import org.junit.Test;

public class MazeTest {

    @Test
    public void testDfs() {
        int[][] map = new int[][] {
                new int[] { 1, 0, 1, 1, 1, 1 },
                new int[] { 1, 0, 1, 0, 1, 0 },
                new int[] { 1, 0, 1, 0, 1, 1 },
                new int[] { 1, 1, 1, 0, 1, 1 },
        };

        Assert.assertEquals(15, Maze.solve(map, map[ 0 ].length, map.length));
    }

    @Test
    public void test2Dfs() {
        int[][] map = new int[][] {
                new int[] { 1, 1, 0, 1, 1, 0 },
                new int[] { 1, 1, 0, 1, 1, 0 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 0, 1 },
        };

        Assert.assertEquals(9, Maze.solve(map, map[ 0 ].length, map.length));
    }

    @Test
    public void testBfs() {
        int[][] map = new int[][] {
                new int[] { 1, 0, 1, 1, 1, 1 },
                new int[] { 1, 0, 1, 0, 1, 0 },
                new int[] { 1, 0, 1, 0, 1, 1 },
                new int[] { 1, 1, 1, 0, 1, 1 },
        };

        Assert.assertEquals(15, Maze.bfs(map));
    }

    @Test
    public void test2Bfs() {
        int[][] map = new int[][] {
                new int[] { 1, 1, 0, 1, 1, 0 },
                new int[] { 1, 1, 0, 1, 1, 0 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 0, 1 },
        };

        Assert.assertEquals(9, Maze.bfs(map));
    }

    @Test
    public void test3Bfs() {
        int[][] map = new int[][] {
                new int[] { 1 }
        };

        Assert.assertEquals(1, Maze.bfs(map));
    }


    @Test
    public void test4Bfs() {
        int[][] map = new int[][] {
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1, 1, 1 },
        };

        Assert.assertEquals(9, Maze.bfs(map));
    }

    @Test
    public void test5Bfs() {
        int[][] map = new int[][] {
                new int[] { 1, 1, 1, 1, 1 },
                new int[] { 0, 0, 0, 0, 1 },
                new int[] { 1, 1, 1, 1, 1 },
                new int[] { 1, 0, 1, 0, 0 },
                new int[] { 1, 1, 1, 1, 1 }
        };

        Assert.assertEquals(13, Maze.bfs(map));
    }

    @Test
    public void test6Bfs() {
        int[][] map = new int[][] {
                new int[] { 1, 1, 1, 1, 1 },
                new int[] { 1, 0, 0, 0, 1 },
                new int[] { 1, 1, 1, 0, 1 },
                new int[] { 0, 1, 0, 0, 1 },
                new int[] { 1, 1, 1, 0, 1 },
                new int[] { 1, 0, 0, 0, 1 },
                new int[] { 1, 1, 1, 1, 1 }
        };

        Assert.assertEquals(11, Maze.bfs(map));
    }


}
