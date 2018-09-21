package com.github.jarviskim.algorithm.programmers;

/**
 * 124나라의 숫자
 *
 * https://programmers.co.kr/learn/challenge_codes/46
 */
class OneTwoFour {
    static final int[] NUMBERS = {1, 2, 4};
    static final int N = 3;

    public String change124(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        int r;
        while (n / N != 0) {
            r = n % N;
            n /= N;
            if (r == 0) {
                r = 3;
                n -= 1;
            }
            answer.append(NUMBERS[r - 1]);
        }
        if (n > 0) {
            answer.append(NUMBERS[n - 1]);
        }


        return answer.reverse().toString();
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        OneTwoFour oneTwoFour = new OneTwoFour();
        System.out.println(oneTwoFour.change124(10));
    }
}
