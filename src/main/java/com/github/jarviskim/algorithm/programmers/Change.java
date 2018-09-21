package com.github.jarviskim.algorithm.programmers;

import java.util.Arrays;

/**
 * 거스름 돈
 * https://programmers.co.kr/learn/challenge_codes/61
 */
class Change {

    /**
     * DP르 이용한 코드.
     * 아래 다른 사람이 짠코드는 n x k 시간인데, 처음에 저런 방식으로 짰는데 왜 난 틀렸다고 나왔었을까.. 개념을 저런식으로 접근했는데..
     */
    public int change(int total, int[] coins) {
        int[][] d = new int[total + 1][coins.length];

        for (int coin = 1; coin <= total; coin++) {
            for (int i = 0; i < coins.length; i++) {
                int startCoin = coins[i];
                int gapCoin = coin - startCoin;
                if (gapCoin > 0) {
                    for (int j = i; j >= 0; j--) {
                        d[coin][i] += d[gapCoin][j];
                    }
                } else if (gapCoin == 0) {
                    d[coin][i] += 1;
                }
            }
        }

        return Arrays.stream(d[total])
                .sum();
    }


    /*
      -- 다른 사람이 짠 코드
        public int change(int total, int[] coins) {
            int dp[] = new int[total+1];
      dp[0] = 1;
      for(int coin : coins){
        for(int i=1; i<dp.length; ++i){
          if(i-coin >= 0) dp[i] += dp[i-coin];
        }
      }
            return dp[total];
    }
     */

    /**
     * 재귀로 짠 코드, 시간 초가 남.
     */
    public int changeByRecursive(int total, int[] coins) {
        return solve(total, coins, coins.length - 1);
    }

    private int solve(int total, int[] conins, int index) {
        if (index < 0) {
            return 0;
        }

        if (total == 0) {
            return 1;
        }

        int sum = 0;
        for (int i = index; i >= 0; i--) {
            if (total - conins[i] >= 0) {
                sum += solve(total - conins[i], conins, i);
            }
        }

        return sum;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Change c = new Change();
        int[] coins = {1, 2, 5};
        System.out.println(c.change(5, coins));
        System.out.println(c.change(4, coins));
        System.out.println(c.change(3, coins));
        System.out.println(c.change(2, coins));

        System.out.println(c.change(10000, coins));
    }
}

