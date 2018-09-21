package com.github.jarviskim.algorithm.programmers;

/**
 * 보행자 천국
 * https://programmers.co.kr/learn/courses/30/lessons/1832?language=java
 * <p>
 * 도시 중심가의 지도는 m × n 크기의 격자 모양 배열 city_map으로 주어진다. 자동차는 오른쪽 또는 아래 방향으로 한 칸씩 이동 가능하다.
 * city_map[i][j]에는 도로의 상황을 나타내는 값이 저장되어 있다.
 * <p>
 * 0인 경우에는 자동차가 자유롭게 지나갈 수 있다.
 * 1인 경우에는 자동차 통행이 금지되어 지나갈 수 없다.
 * 2인 경우는 보행자 안전을 위해 좌회전이나 우회전이 금지된다. (왼쪽에서 오던 차는 오른쪽으로만, 위에서 오던 차는 아래쪽으로만 진행 가능하다)
 * <p>
 * 입력 형식
 * 입력은 도시의 크기를 나타내는 m과 n, 그리고 지도를 나타내는 2차원 배열 city_map으로 주어진다. 제한조건은 아래와 같다.
 * <p>
 * 1 <= m, n <= 500
 * city_map의 크기는 m × n이다.
 * 배열의 모든 원소의 값은 0, 1, 2 중 하나이다.
 * 출발점의 좌표는 (0, 0), 도착점의 좌표는 (m - 1, n - 1)이다.
 * 출발점과 도착점의 city_map[i][j] 값은 0이다.
 */
public class HavenOfPedestrian {

    static class Solution {
        int MOD = 20170805;

        /* DP */
        public int solution(int m, int n, int[][] cityMap) {
            int[][] dpFromAbove = new int[m + 1][n + 1];
            int[][] dpFromLeft = new int[m + 1][n + 1];
            int[][] map = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                System.arraycopy(cityMap[i], 0, map[i + 1], 1, n);
            }

            dpFromAbove[1][0] = 0;
            dpFromLeft[0][1] = 1;
            for (int y = 1; y <= m; y++) {
                for (int x = 1; x <= n; x++) {
                    if (map[y][x] != 1) {
                        if (map[y - 1][x] == 0) {           // 우회전, 자회전 가능
                            dpFromAbove[y][x] += (dpFromAbove[y - 1][x] + dpFromLeft[y - 1][x]) % MOD;
                        } else if (map[y - 1][x] == 2) {    // 윗쪽에서 온것만 가능
                            dpFromAbove[y][x] += dpFromAbove[y - 1][x];
                        }
                        dpFromAbove[y][x] %= MOD;

                        if (map[y][x - 1] == 0) {           // 우회전, 자회전 가능
                            dpFromLeft[y][x] += (dpFromAbove[y][x - 1] + dpFromLeft[y][x - 1]) % MOD;
                        } else if (map[y][x - 1] == 2) {    // 오른쪽에서 온것만 가능
                            dpFromLeft[y][x] += dpFromLeft[y][x - 1];
                        }
                        dpFromAbove[y][x] %= MOD;
                    }

                }
            }

            return (dpFromAbove[m][n] + dpFromLeft[m][n]) % MOD;
        }

        /* DFS */
        static class Navi {
            static int MOD = 20170805;
            int[][] cityMap;
            int m;
            int n;

            public Navi(int m, int n, int[][] cityMap) {
                this.cityMap = cityMap;
                this.m = m;
                this.n = n;
            }

            /**
             * 시간 초과
             */
            int solution(int x, int y, int priorToX, int priorToY) {
                if (x == n - 1 && y == m - 1) {
                    return 1;
                }

                int answer = 0;
                /* 우회전 금지 */
                if (x + 1 < n &&
                        cityMap[y][x + 1] != 1 &&
                        (cityMap[y][x] == 0 || (cityMap[y][x] == 2 && x == priorToX + 1))) {
                    answer = (answer + solution(x + 1, y, x, y)) % MOD;
                }

                /* 좌회전 금지 */
                if (y + 1 < m && cityMap[y + 1][x] != 1 &&
                        (cityMap[y][x] == 0 || (cityMap[y][x] == 2 && y == priorToY + 1))) {
                    answer = (answer + solution(x, y + 1, x, y)) % MOD;
                }

                return answer;
            }
        }
    }
}