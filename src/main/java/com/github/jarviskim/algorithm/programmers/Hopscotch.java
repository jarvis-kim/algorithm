package com.github.jarviskim.algorithm.programmers;

import java.util.Arrays;

/**
 * 땅따먹기 게임
 * Level 4
 *
 * https://programmers.co.kr/learn/challenge_codes/34
 *
 * 코드 설명
 * 가장 많이 밟은 점수는 = max(d[n][])
 * d[i][j] = j와 k가 같지 않은 경우, d[i-1][k]의 최대값.
 * d[i][] 라인에서 최대값이 가장 많이 밟은 점수인데, d[i+1][]의 최대값은 d[i][]의 최대값이 영향을 미친다.(단, j != k 일때)
 *
 * 시간 복잡도 : O(nm^2)
 *
 * 최대한 O(mn)으로 해보려 했지만 지식의 부족으로 O(mn)까지는 찾지 못하였다....
 */
public class Hopscotch {
    int hopscotch(int[][] board, int size) {
        int[][] d = new int[board.length][board[0].length];

        for (int i = 0; i < board[0].length; i++) {
            d[0][i] = board[0][i];
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < board[i].length; k++) {
                    if (k != j) {
                        d[i][j] = Math.max(d[i - 1][k] + board[i][j], d[i][j]);
                    }
                }
            }
        }

        return Arrays.stream(d[d.length - 1])
                .max()
                .getAsInt();
    }

    public static void main(String[] args) {
        Hopscotch c = new Hopscotch();
        int[][] test = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.hopscotch(test, 3));
    }

}