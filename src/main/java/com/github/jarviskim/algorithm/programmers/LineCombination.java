package com.github.jarviskim.algorithm.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 줄 서는 방법
 * https://programmers.co.kr/learn/challenge_codes/49
 *
 * N명의 줄서는 방법은 N! 이므로
 * N명 줄서기에서 k번째의 첫번째 숫자는 k / (N! / N)이다.
 * 다음 N - 1명에서 (N-1)! 이고, 다음 k는 N번째 줄서기에서 k % (N! / N) 인데,
 * 이유는 N이 줄어들었으므로 비율에 맞게 k를 줄인다.
 */
class LineCombination {
    public int[] setAlign(int n, long k) {
        int[] numbers = IntStream.range(1, n +1)
                .toArray();
        
        int[] answer = new int[ n ];

        for ( int i = 0; i < n; i++ ) {
            long factorial = factorial(numbers.length);
            long size = factorial / numbers.length;
            int numberIndex = (int) ((k - 1) / size + 1);

            int number = numbers[ numberIndex - 1];
            answer[ i ] = number;

            numbers = IntStream.of(numbers)
                    .filter(value -> value != number)
                    .toArray();

            k %= size;
            if ( k == 0 ) {
                k = size;
            }
        }

        return answer;
    }

    private long factorial(int n) {
        return LongStream.range(1, n + 1)
                .reduce((left, right) -> left * right)
                .getAsLong();
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        LineCombination lc = new LineCombination();

        System.out.println(Arrays.toString(lc.setAlign(13, 4880474667L)));

//        System.out.println(Arrays.toString(lc.setAlign(4, 18)));
//        System.out.println(Arrays.toString(lc.setAlign(3, 5)));
//        System.out.println(Arrays.toString(lc.setAlign(5, 118)));
    }
}
