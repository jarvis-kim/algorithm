package com.github.jarviskim.algorithm.programmers;

/**
 * 가장 큰 정사각형 찾기
 * Level 4
 *
 * https://programmers.co.kr/learn/challenge_codes/188
 *
 */
class LargestSquare {
    private final static char OK = 'O';

    public int findLargestSquare(char[][] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == OK) {
                    int count = 1;
                    while (check(i, j + count, count, board)) {
                        count++;
                    }
                    answer = Math.max(answer, count * count);
                }
            }
        }
        return answer;
    }

    private boolean check(int i, int j, int count, char[][] board) {
        if (j >= board[i].length || i + count >= board.length) {
            return false;
        }

        for (int cnt = 0; cnt < count + 1; cnt++) {
            if (board[i++][j] != OK) {
                return false;
            }
        }

        i--;
        for (int cnt = 0; cnt < count; cnt++) {
            if (board[i][--j] != OK) {
                return false;
            }
        }

        return true;
    }

    /**
     * 다른 사람의 풀이로 다시 함.
     * O(n^2)이 됨. 대단하다 진짜. 어떻게 DP로 할 생각을..
     *
     * 가장 큰 정사각형은 = max(d)
     * d[i][j] = min(d[i-1][j-1], d[i-1][j], d[i][j-1]) + 1
     *
     * d[i][j]가 (왼쪽 대각석, 왼쪽, 상단)에서 가장 작은 값에 + 1을 한 이유는
     * board[i][j] == 'O'이면, i,j의 (왼쪽 대각석, 왼쪽, 상단)은 이전의 정사각형의 개수이다.
     * 그중 가장 작은 값을 취하는것은 i,j가 오른쪽 하단 모서리로써 3방면의 값중 가장 작은 값이 i,j(모서리)까지 오는길의 정사각형이 된것을 말한기때문이다.
     * 그후 +1 (자기자신)을 한다.
     * @param board
     * @return
     */
    public int findLargestSquare2(char[][] board) {
        int answer = 0;
        int[][] square = new int[board.length][board[0].length];

        for (int i = 1; i < board.length; i++)
            if (board[i][0] == 'O') square[i][0] = 1;

        for (int j = 0; j < board[0].length; j++)
            if (board[0][j] == 'O') square[0][j] = 1;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    square[i][j] = Math.min(square[i - 1][j - 1], Math.min(square[i - 1][j], square[i][j - 1])) + 1;
                    answer = Math.max(answer, square[i][j]);
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        LargestSquare test = new LargestSquare();
        char[][] board = {
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'X', 'X', 'X'}};

        System.out.println(test.findLargestSquare(board));
    }
}