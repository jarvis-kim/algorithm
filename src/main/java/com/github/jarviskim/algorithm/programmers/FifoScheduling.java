package com.github.jarviskim.algorithm.programmers;

/**
 * 선입선출 스케줄링
 * Level 8
 * https://programmers.co.kr/learn/challenge_codes/79
 */
public class FifoScheduling {

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        FifoScheduling fifo = new FifoScheduling();
        int[] core = {1, 2, 3};
        System.out.println(fifo.getCoreNumber(6, core));
    }

    public int getCoreNumber(int n, int[] core) {
        int answer = 0;
        int[] proccessing = new int[core.length];

        int hour = 1;

        while (hour <= n) {
            int tempHour = hour;
            for (answer = 0; answer < core.length && hour <= n; answer++) {
                if (proccessing[answer] > 0) {
                    proccessing[answer]--;
                }
                if (proccessing[answer] == 0) {
                    proccessing[answer] = core[answer];
                    hour++;
                }
            }
            answer--;
            if (hour == tempHour) {
                hour++;
            }
        }

        return answer + 1;
    }
}
