package com.github.jarviskim.algorithm.mailprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 0과 1로 만들어진 2D 정수 배열이 있습니다. 0은 장애물이고 1은 도로일때, 두 좌표가 주어지면, 첫번째 좌표에서 두번째 좌표까지 가장 가까운 거리를 구하시오.
 * 두 좌표는 모두 도로에서 시작되고 좌, 우, 아래, 위로 움직이며 대각선으로는 움직일 수 없습니다. 만약 갈 수 없다면 -1을 리턴하시오.

 예제)
 Input:
 {{1, 0, 0, 1, 1, 0},
 {1, 0, 0, 1, 0, 0},
 {1, 1, 1, 1, 0, 0},
 {1, 0, 0, 0, 0, 1},
 {1, 1, 1, 1, 1, 1}}

 Start: (0, 0)
 Finish: (0, 4)

 Output: 8
 */
public class Quiz17 {

    public static int solve(int[][] map, final Pos start, final Pos finish) {
        int rowLength = map.length;
        int colLength = map[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        visited[start.y][start.x] = true;

        List<Pos> list = new ArrayList<Pos>() {{
            add(start);
        }};

        int count = 0;
        while (list != null) {
            List<Pos> nextPositions = new ArrayList<>();
            for (Pos pos : list) {
                if (pos.equals(finish)) {
                    return count;
                }

                addAndMarkIfNotVisited(map, visited, nextPositions, new Pos(pos.x, pos.y + 1));
                addAndMarkIfNotVisited(map, visited, nextPositions, new Pos(pos.x, pos.y - 1));
                addAndMarkIfNotVisited(map, visited, nextPositions, new Pos(pos.x + 1, pos.y));
                addAndMarkIfNotVisited(map, visited, nextPositions, new Pos(pos.x - 1, pos.y));
            }

            list = nextPositions.size() > 0 ? nextPositions : null;
            count++;
        }

        return -1;
    }

    private static void addAndMarkIfNotVisited(int[][] map, boolean[][] visited, List<Pos> nextPositions, Pos pos) {
        if (notVisited(map, visited, pos)) {
            nextPositions.add(pos);
            visited[pos.y][pos.x] = true;
        }
    }

    private static boolean notVisited(int[][] map, boolean[][] visited, Pos pos) {
        return (0 <= pos.x && pos.x < map[0].length) &&
                (0 <= pos.y && pos.y < map.length) &&
                !visited[pos.y][pos.x] &&
                map[pos.y][pos.x] == 1;
    }

    public static void main(String[] args) {

    }

    static class Pos {
        final int x;
        final int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
