package com.github.jarviskim.algorithm.programmers;

import java.util.stream.Stream;

/**
 * 캠핑
 * https://programmers.co.kr/learn/courses/30/lessons/1833?language=java
 */

public class Camping {


    public int solution(int n, int[][] data) {
        return new Solution().solution(n, data);
    }

    class Solution {
        public int solution(int n, int[][] data) {
            int answer1 = 0;

            // 좌표를 오름차순으로 정렬
            int[][] sortedDataAsc = Stream.of(data)
                    .sorted((o1, o2) -> o1[0] == o2[0]
                            ? Integer.compare(o2[1], o1[1])
                            : Integer.compare(o1[0], o2[0]))
                    .toArray(int[][]::new);

            // 오름차순으로 정렬된 좌표에서 현재 좌표보다 X축으로 오른쪽에 있는 것들만 검사한다.
            for (int i = 0; i < n; i++) {
                int y = sortedDataAsc[i][0];
                int x = sortedDataAsc[i][1];

                int minX = Integer.MAX_VALUE;
                for (int j = i; j < n; j++) {
                    int targetY = sortedDataAsc[j][0];
                    int targetX = sortedDataAsc[j][1];

                    // minX보다 TargetX가 크다는것은 더이상 이미 사각형 안에 쇄기가 있다는것이다.
                    // 오른차순으로 정렬된 좌표에서 가장 가까운 쇄기부터 검사했기때문이다.
                    if (minX >= targetX) {
                        if (x < targetX && y < targetY) {
                            answer1++;
                            minX = Math.min(targetX, minX);
                        }
                    }

                }

            }

            int answer2 = 0;
            // 좌표를 내림차순으로 정렬
            int[][] sortedDataDesc = Stream.of(data)
                    .sorted((o1, o2) -> o1[0] == o2[0]
                            ? Integer.compare(o2[1], o1[1])
                            : Integer.compare(o2[0], o1[0]))
                    .toArray(int[][]::new);

            // 내림차순으로 정렬된 좌표에 대해서 위와 같은 검사를 한다.
            for (int i = 0; i < n; i++) {
                int y = sortedDataDesc[i][0];
                int x = sortedDataDesc[i][1];

                int minX = Integer.MAX_VALUE;
                for (int j = i; j < n; j++) {
                    int targetY = sortedDataDesc[j][0];
                    int targetX = sortedDataDesc[j][1];
                    if (minX >= targetX) {
                        if (x < targetX && y > targetY) {
                            answer2++;
                            minX = Math.min(targetX, minX);
                        }
                    }

                }

            }

            return answer1 + answer2;
        }
    }

}