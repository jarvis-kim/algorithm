package com.github.jarviskim.algorithm.programmers;

/**
 * 숫자의 표현
 * Level 4
 * https://programmers.co.kr/learn/challenge_codes/40
 *
 * 수학을 공부하던 민지는 재미있는 사실을 발견하였습니다. 그 사실은 바로 연속된 자연수의 합으로 어떤 숫자를 표현하는 방법이 여러 가지라는 것입니다. 예를 들어, 15를 표현하는 방법은
 * (1+2+3+4+5)
 * (4+5+6)
 * (7+8)
 * (15)
 * 로 총 4가지가 존재합니다. 숫자를 입력받아 연속된 수로 표현하는 방법을 반환하는 expressions 함수를 만들어 민지를 도와주세요. 예를 들어 15가 입력된다면 4를 반환해 주면 됩니다.
 */
public class Expressions {

    /**
     * 다른 사람 풀이
     * 댓글중
     * 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있습니다. ― 박동규 2018.2.7 20:51
     */
    public int expressions2(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2) {
            if (num % i == 0) {
                answer++;
            }
        }
        return answer;
    }

    public int expressions(int num) {
        int answer = 0;

        for (int number = 1; number <= num; number++) {
            int sum = 0;
            for (int i = number; i <= num && sum < num; i++) {
                sum += i;
            }
            if (sum == num) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        Expressions expressions = new Expressions();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(expressions.expressions(15));
    }
}