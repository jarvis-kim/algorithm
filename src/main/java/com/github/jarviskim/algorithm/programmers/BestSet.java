package com.github.jarviskim.algorithm.programmers;

import java.util.Arrays;

/**
 * 최고의 집합
 * Level 4
 *
 * https://programmers.co.kr/learn/challenge_codes/37
 */
public class BestSet {

    public int[] bestSet(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int div = s / n;
        int reminder = s % n;

        int index = 0;
        for (int i = 0; i < (n - reminder); i++) {
            answer[index++] = div;
        }

        for (int i = 0; i < reminder; i++) {
            answer[index++] = div + 1;
        }

//        다른 사람 코드 : 엄청 간결하네..!!
//        for(int i=n; 0 < i; i--) {
//            answer[n-i] = s / i;
//            s -= answer[n-i];
//        }

        return answer;
    }

    public static void main(String[] args) {
        BestSet c = new BestSet();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(Arrays.toString(c.bestSet(3, 13)));
    }

}