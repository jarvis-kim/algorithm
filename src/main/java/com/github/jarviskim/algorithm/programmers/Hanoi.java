package com.github.jarviskim.algorithm.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

class Hanoi {
    private final static int N = 3;

    public int[][] hanoi(int n) {
        // 2차원 배열을 완성해 주세요.
        final int moveCount = (int) (Math.pow(2, n) - 1);
        int[][] answer = new int[moveCount + 1][];

        int from;
        int to;

        int q = 4;
        int j = 0;
        for (int i = 1; i < n; i++) {
            from = 0;
            to = i % 2 + 1;
            while (j < q) {
                answer[j++] = new int[]{from + 1, to + 1};
                answer[j++] = new int[]{from + 1, ++to % N + 1};
                answer[j++] = new int[]{from + 1, ++to % N + 1};
                answer[j++] = new int[]{++from % N + 1, to + 1};
                if (--from < 0) from = 2;
                if( --to < 0) to = 2;
            }

            q *= 2;
        }
        int[][] result = new int[moveCount][];
        System.arraycopy(answer, 1, result, 0, result.length);

        return result;
    }

    public void solve(int from, int to, int n) {
        if (n <= 1) {
            System.out.printf("[%d, %d]", from, to);
            System.out.println();
            return;
        }
        solve(from, 6-from-to, n-1);
        System.out.printf("[%d, %d]", from, to);
        System.out.println();
        solve(6-from-to, to, n-1);
    }


    private String toString(int[][] arrays) {
        return Arrays.stream(arrays)
                .map(Arrays::toString)
                .collect(Collectors.joining(", ", "[ "," ]"));
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Hanoi h = new Hanoi();

        h.solve(1, 2, 3);
//        System.out.println(h.toString(h.hanoi(3)));
    }
}
