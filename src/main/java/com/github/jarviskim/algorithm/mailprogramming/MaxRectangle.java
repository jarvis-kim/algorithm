package com.github.jarviskim.algorithm.mailprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 0과 1로 만들어진 2차원 정수 배열을 나열했을때, 1로 이루어진 가장 큰 사각형의 넓이를 구하시오.
 * <p>
 * 예)
 * input:
 * 0 0 1 0 1
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 1 0 1 0
 * 0 1 0 1 1
 * <p>
 * output: 6 // 2 * 3
 * <p>
 * 풀이 : 대각선, 좌, 상 모두 1이라면 사각형이라고 본다.
 * <p>
 * <b>단, 만약 한줄도 사각형이라고 본다면, 대각선 뿐만아니라 위에서 내려오는 가장 큰 직선과,
 * 왼쪽에서 오는 가증 큰 직선도 따로 저장하여, 대각서, 좌, 상에서 가장 큰 값을 구해야한다.</b>
 */
public class MaxRectangle {

    public static int solve(int[][] map) {
        Point[][] rectMap = new Point[map.length][map[0].length];

        for (int i = 0; i < rectMap.length; i++) {
            rectMap[0][i] = map[0][i] == 1
                    ? new Point(1, 1)
                    : new Point(0, 0);
        }

        for (int i = 0; i < rectMap[0].length; i++) {
            rectMap[i][0] = map[i][0] == 1
                    ? new Point(1, 1)
                    : new Point(0, 0);
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] == 1 && map[i - 1][j - 1] == 1 && map[i - 1][j] == 1 && map[i][j - 1] == 1) {
                    rectMap[i][j] = new Point(rectMap[i][j - 1].x + 1, rectMap[i - 1][j].y + 1);
                } else if (map[i][j] == 1) {
                    rectMap[i][j] = new Point(1, 1);
                } else {
                    rectMap[i][j] = new Point(0, 0);
                }
            }
        }

        return Arrays.stream(rectMap)
                .flatMap(Arrays::stream)
                .max(Comparator.comparingInt(Point::result))
                .get()
                .result();
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 0, 1, 1}
        };

        System.out.println(solve(map));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        int result() {
            return x * y;
        }
    }
}
