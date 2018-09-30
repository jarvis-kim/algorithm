package com.github.jarviskim.algorithm.book.apss_insignht.dp;

import static java.lang.Math.*;

/**
 * 삼각형 위의 최대 경로 (난이도: 하)
 * 문제 : 아래쪽이나 오른쪽 아래로만 내려가면서 합이 최대치인 구간 찾기
 * 페이지 : 226
 * maxSum(y,x) = (y,x)부터 마지막까지 내려가면서 최대의 구간 합을 반환.
 */
public class TrianglePath {

    private int[][] triangle;
    private Integer[][] memoization;

    public TrianglePath(int[][] triangle) {
        this.triangle = triangle;
        this.memoization = new Integer[triangle.length][triangle.length];
    }

    public int maxSum() {
        return maxSum(0, 0);
    }

    public int maxSum(int y, int x) {
        if (y == triangle.length - 1) {
            return triangle[y][x];
        }

        if (memoization[y][x] != null) {
            return memoization[y][x];
        }

        memoization[y][x] = max(maxSum(y + 1, x), maxSum(y + 1, x + 1)) + triangle[y][x];
        return memoization[y][x];
    }
}
