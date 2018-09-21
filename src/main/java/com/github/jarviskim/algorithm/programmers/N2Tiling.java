package com.github.jarviskim.algorithm.programmers;

import java.util.stream.IntStream;

/**
 * 1x1 정사각형 2개가 붙어 있는 타일이 있습니다. 이 타일을 이용하여 총 2xN 의 보드판을 채우려고 합니다. 타일은 가로, 세로 두 가지 방향으로 배치할 수 있습니다.
 보드판의 길이 N이 주어질 때, 2xN을 타일로 채울 수 있는 경우의 수를 반환하는 tiling 함수를 완성하세요.
 */
public class N2Tiling {

    static final int MOD = 100000;
    public int tiling(int n) {
        int[] answer = new int[n];
        answer[ 0 ] = 1;
        answer[ 1 ] = 2;

        IntStream.range(2, n)
                .forEach(index -> answer[ index ] = (answer[ index - 1 ] + answer[ index - 2 ]) % MOD);

        return answer[ n - 1 ];
    }

    public static void main(String[] args) {
        N2Tiling tryHelloWorld = new N2Tiling();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.print(tryHelloWorld.tiling(126));
    }
}
