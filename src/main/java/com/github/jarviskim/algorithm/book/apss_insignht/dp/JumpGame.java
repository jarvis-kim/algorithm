package com.github.jarviskim.algorithm.book.apss_insignht.dp;

/**
 * 외발 뛰기 (난이도 : 하)
 * 문제 : 가장 왼쪽 위부터 가장 오른쪽 아래로 갈수 있는가 판단한다.
 *       주어진 Map안의 숫자만큼 이동할 수 있다.
 * 페이지 : 215p
 */
public class JumpGame {

    /**
     * 전략 : 모든 경우의 수를 계산
     * 중복 호출 횟수가 많다.
     */
    public static class Recursive {
        private int[][] map;
        private int n;
        private int m;
        private int callCount = 0;
        public Recursive(int[][] map) {
            this.map = map;
            this.n = map.length;
            this.m = map[0].length;
        }
        public boolean canJump() {
            return canJump(0, 0);
        }

        public boolean canJump(int i, int j) {
            callCount++;
            if (i == n - 1 && j == m - 1) {
                return true;
            }

            int jump = map[i][j];
            boolean can = false;
            if (i + jump < n) {
                can |= canJump(i + jump, j);
            }
            if (j + jump < m) {
                can |= canJump(i, j + jump);
            }

            return can;
        }

        public int getCallCount() {
            return callCount;
        }
    }

    /**
     * 모든 경우수를 계산하지만, 메모이제이션 적용
     * 중복이 없다.
     */
    public static class Memoization {
        private int[][] map;
        private int[][] memoization;
        private int n;
        private int m;
        private int callCount = 0;

        public Memoization(int[][] map) {
            this.map = map;
            this.n = map.length;
            this.m = map[0].length;
            this.memoization = new int[n][m];
        }

        public boolean canJump() {
            return canJump(0, 0);
        }

        public boolean canJump(int i, int j) {
            callCount++;
            if (memoization[i][j] != 0) {
                return memoization[i][j] == 1;
            }
            if (i == n - 1 && j == m - 1) {
                return true;
            }

            int jump = map[i][j];
            boolean can = false;
            if (i + jump < n) {
                can |= canJump(i + jump, j);
            }
            if (j + jump < m) {
                can |= canJump(i, j + jump);
            }
            memoization[i][j] = can ? 1 : -1;
            return can;
        }

        public int getCallCount() {
            return callCount;
        }
    }

}
