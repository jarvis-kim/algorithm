package com.github.jarviskim.algorithm.book.apss_insignht.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    @Test
    public void canJump_by_recursive() {
        int[][] input_case1 = {
                {2,5,1,6,1,4,1},
                {6,1,1,2,2,9,3},
                {7,2,3,2,1,3,1},
                {1,1,3,1,7,1,2},
                {4,1,2,3,4,1,2},
                {3,3,1,2,3,4,1},
                {1,5,2,9,4,7,0}
        };
        JumpGame.Recursive jumpGame_case1 = new JumpGame.Recursive(input_case1);
        boolean expected_case1 = true;
        assertEquals(expected_case1, jumpGame_case1.canJump());
        System.out.println("case1 - call method count by recursive : " + jumpGame_case1.getCallCount());


        int[][] input_case2 = {
                {2,5,1,6,1,4,1},
                {6,1,1,2,2,9,3},
                {7,2,3,2,1,3,1},
                {1,1,3,1,7,1,2},
                {4,1,2,3,4,1,3},
                {3,3,1,2,3,4,1},
                {1,5,2,9,4,7,0}
        };
        JumpGame.Recursive jumpGame_case2 = new JumpGame.Recursive(input_case2);
        boolean expected_case2 = false;
        assertEquals(expected_case2, jumpGame_case2.canJump());
        System.out.println("case2 - call method count by recursive : " + jumpGame_case2.getCallCount());


        int[][] input_case3 = {
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,2},
                {1,1,1,1,1,2,0},
        };
        JumpGame.Recursive jumpGame_case3 = new JumpGame.Recursive(input_case3);
        boolean expected_case3 = false;
        assertEquals(expected_case3, jumpGame_case3.canJump());
        System.out.println("case3 - call method count by recursive : " + jumpGame_case3.getCallCount());
    }


    @Test
    public void canJump_by_memoization() {
        int[][] input_case1 = {
                {2,5,1,6,1,4,1},
                {6,1,1,2,2,9,3},
                {7,2,3,2,1,3,1},
                {1,1,3,1,7,1,2},
                {4,1,2,3,4,1,2},
                {3,3,1,2,3,4,1},
                {1,5,2,9,4,7,0}
        };
        JumpGame.Memoization jumpGame_case1 = new JumpGame.Memoization(input_case1);
        boolean expected_case1 = true;
        assertEquals(expected_case1, jumpGame_case1.canJump());
        System.out.println("case1 - call method count by memoization : " + jumpGame_case1.getCallCount());


        int[][] input_case2 = {
                {2,5,1,6,1,4,1},
                {6,1,1,2,2,9,3},
                {7,2,3,2,1,3,1},
                {1,1,3,1,7,1,2},
                {4,1,2,3,4,1,3},
                {3,3,1,2,3,4,1},
                {1,5,2,9,4,7,0}
        };
        JumpGame.Memoization jumpGame_case2 = new JumpGame.Memoization(input_case2);
        boolean expected_case2 = false;
        assertEquals(expected_case2, jumpGame_case2.canJump());
        System.out.println("case2 - call method count by memoization : " + jumpGame_case2.getCallCount());

        int[][] input_case3 = {
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,2},
                {1,1,1,1,1,2,0},
        };
        JumpGame.Memoization jumpGame_case3 = new JumpGame.Memoization(input_case3);
        boolean expected_case3 = false;
        assertEquals(expected_case3, jumpGame_case3.canJump());
        System.out.println("case3 - call method count by recursive : " + jumpGame_case3.getCallCount());
    }
}