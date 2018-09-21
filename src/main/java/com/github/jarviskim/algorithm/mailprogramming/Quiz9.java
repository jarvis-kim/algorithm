package com.github.jarviskim.algorithm.mailprogramming;

/*
*    안녕하세요, 매일프로그래밍 이번주 문제입니다.
*    정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오. 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
*    예제)
*        Input: [0, 5, 0, 3, -1]
*        Output: [5, 3, -1, 0, 0]
*
*        Input: [3, 0, 3]
*        ﻿Output: [3, 3, 0]
*/

import java.util.Arrays;

public class Quiz9 {

    public static int[]  zeroRight(int[] arr) {
        int startZeroIndex = 0;
        int zeroCount = 1;

        while (startZeroIndex < arr.length && arr[startZeroIndex] != 0) {
            startZeroIndex++;
        }

        for (int index = startZeroIndex + 1; index < arr.length; index++) {
            if (arr[index] == 0) {
                zeroCount++;
            } else {
                arr[index - zeroCount] = arr[index];
                arr[index] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(zeroRight(new int[]{0, 5, 0, 3, -1})));
        System.out.println(Arrays.toString(zeroRight(new int[]{3, 0, 3})));
    }
}
