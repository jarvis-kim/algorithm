package com.github.jarviskim.algorithm.programmers;

/**
 * 과자 많이 먹기
 * https://programmers.co.kr/learn/challenge_codes/58
 *
 * 전략, 이전보다 현재 쿠기가 큰경우 큰경우 최대값을 구함. O(n^2)
 *
 * 다른사람풀이에서 보니깐 이진검색을 이용하여 O(nlogn)으로 풀이가 있음
 *   -> 쿠키를 순차적으로 순회
 *   -> 각 쿠키마다 이진탐색할 배열에 이진탐색함. 현재 쿠키보다 작은 쿠키를 찾고, 그 이진 탐색 배열에 새로운 갑으로 대체
 *   -> 만약 해당 쿠키가 제일 크다면 가장 오른쪽 끝에 추가하고 이진 팀섹힐 베얄을 1 늘림.
 *   -> 이진 탐색의 끝 length가 최대 값임.
 *
 * 나도 트리로 해보려고 시도해봤는데 치환 하는걸로 했어야했는데 마지막에 막힘.
 *
 */
class EatCookie {

    public int eatCookie(int[] cookies) {
        int answer = 0;
        int[] d = new int[cookies.length];
        d[0] = 1;
        answer = d[0];

        for (int i = 1; i < cookies.length; i++) {
            d[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (cookies[i] > cookies[j]) {
                    d[i] = Math.max(d[j] + 1, d[i]);
                }
            }
            answer = Math.max(answer, d[i]);
        }

        return answer;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        EatCookie e = new EatCookie();
        int[] cookies = {1, 4, 2, 6, 3, 4, 1, 5};
        System.out.println(e.eatCookie(cookies));
        System.out.println(e.eatCookie(new int[]{1, 2, 3, 4, 5}));
        System.out.println(e.eatCookie(new int[]{5, 4, 3, 2, 1}));
        System.out.println(e.eatCookie(new int[]{3, 4, 7, 10, 8, 9, 1, 6, 7, 8, 9}));
        System.out.println(e.eatCookie(new int[]{1, 4, 2, 6, 3, 4, 1, 5}));
    }
}

