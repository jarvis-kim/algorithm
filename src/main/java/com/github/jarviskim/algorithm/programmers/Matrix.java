package com.github.jarviskim.algorithm.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 최적의 행렬 곱셈
 * Level 8
 * https://programmers.co.kr/learn/challenge_codes/76
 *
 * matrix[i][j] = minimum(matrix[i][k] + matrix[k + 1][j] + (d[i - 1] * d[k] * d[j])
 *                k = i, k < j 까지
 */
class Matrix {
    // 실행을 위한 테스트코드입니다.
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] list = {{5, 3}, {3, 2}, {2, 6}};
        if (matrix.matrix(list) == 90) {
            System.out.println("{{5,3},{3,2},{2,6}}인 경우에 정상동작합니다. 제출을 눌러서 다른 경우에도 정답인지 확인해 보세요.");
        } else {
            System.out.println("{{5,3},{3,2},{2,6}}인 경우에 정상동작하지 않습니다.");
        }
    }

    public int matrix(int[][] list) {
        int[] d = IntStream.concat(
                Arrays.stream(list).mapToInt(v -> v[0]),
                IntStream.of(list[list.length - 1][1])
        ).toArray();

        int[][] matrix = new int[list.length + 1][list.length + 1];
        int n = list.length;
        for (int y = 2; y <= n; y++) {
            for (int x = 1; x <= n - y + 1; x++) {
                int i = x;
                int j = y + x - 1;
                matrix[i][j] = Integer.MAX_VALUE;
                for (int k = x; k < j; k++) {
                    int tmp = matrix[i][k] + matrix[k + 1][j] + (d[i - 1] * d[k] * d[j]);
                    matrix[i][j] = Math.min(tmp, matrix[i][j]);
                }
            }
        }

        return matrix[1][n];
    }
}