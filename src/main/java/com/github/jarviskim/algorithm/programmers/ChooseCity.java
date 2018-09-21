package com.github.jarviskim.algorithm.programmers;

import java.util.Arrays;

/**
 * 공항 건설하기
 * <p>
 * https://programmers.co.kr/learn/challenge_codes/184
 *
 * 주석 친 코드가 나의 코드이다. O(n^2)이 걸리는데도 타임 아웃으로 나오는거같은데.. 다른 사람 풀이도 다 n^2이던데..;
 */
class ChooseCity {

    /**
     * 참고 코드 : https://pignuante.github.io/2017-06-21/TryHelloWorldLevel4_2/
     * "자신의 좌측의 값이 전체 인구수의 절반이 넘어가면 좌우로의 이동의 평균 지점이 되므로 가장 효율적인 위치가 아닐까하여 생각한 방식이 위의 코드이다."
     * 로 설명 되어있는데 그런데...아직도 이해가 안간다...
     */
    public int chooseCity(int n, int[][] city) {
        int answer = 0;
        int total = Arrays.stream(city)
                .mapToInt(ints -> ints[1])
                .sum();
        int half = total / 2;

        int sum = 0;
        for (int[] c : city) {
            sum += c[1];
            if (sum >= half) {
                answer = c[0];
                break;
            }
        }


        return answer;
    }

//    public int chooseCity(int n, int[][] city) {
//        int answer = city[0][0];
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < city.length; i++) {
//            int sum = 0;
//            for (int j = 0; j < city.length; j++) {
//                if (i != j) {
//                    sum += city[j][1] * Math.abs(city[i][0] - city[j][0]);
//                }
//            }
//            if (min > sum) {
//                answer = city[i][0];
//                min = sum;
//            }
//        }
//
//        return answer;
//    }


    public static void main(String[] args) {
        ChooseCity test = new ChooseCity();
        int tn = 3;
        int[][] tcity = {{1, 5}, {2, 2}, {3, 3}};
        System.out.println(test.chooseCity(tn, tcity));

        int[][] tcity2 = {{1, 7}, {2, 3}, {3, 4}, {4, 6}};
        System.out.println(test.chooseCity(tn, tcity2));

    }
}
