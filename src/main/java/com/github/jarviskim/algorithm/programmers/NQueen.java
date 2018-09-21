package com.github.jarviskim.algorithm.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Math.abs;

/**
 * N-Queen
 * Level 7
 * https://programmers.co.kr/learn/challenge_codes/67
 */

class NQueen {

    public int nQueen(int n) {
        return queen(new ArrayDeque<>(), 0, n);
    }

    /**
     * 깊이 우선 탐색..은 시간 초과
     * 정정 -> 시간 초과라고 떠놓고선 정답으로 표시됨.
     * 다시 제출해보니 통과.
     *
     * @param pos 현재까지 방문한 좌표
     * @param y 세로 축
     * @param n N
     * @return 결과
     */
    private int queen(Deque<Position> pos, int y, int n) {
        if (y >= n) {
            return 1;
        }

        int result = 0;
        for (int x = 0; x < n; x++) {
            if (checkQueen(pos, y, x)) {
                pos.push(new Position(y, x));
                result += queen(pos, y + 1, n);
                pos.pop();
            }
        }

        return result;
    }

    private boolean checkQueen(Deque<Position> pos, int y, int x) {
        boolean pass = pos.stream()
                .noneMatch(p -> p.x == x);

        pass &= pos.stream()
                .noneMatch(p -> abs(p.y - y) == abs(p.x - x));

        return pass;
    }

    class Position {
        final int y;
        final int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        NQueen nq = new NQueen();
        System.out.println(nq.nQueen(3));
    }

}
