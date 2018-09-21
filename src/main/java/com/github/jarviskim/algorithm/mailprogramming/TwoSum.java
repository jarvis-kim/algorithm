package com.github.jarviskim.algorithm.mailprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 정수 배열과 타겟 숫자가 주어지면, 합이 타겟값이 되는 두 원소의 인덱스를 찾으시오.
 * 단, 시간복잡도 O(n) 여야 합니다.
 * <p>
 * 예제)
 * <p>
 * Input: [2, 5, 6, 1, 10], 타겟 8
 * Output: [0, 2] // 배열[0] + 배열[2] = 8
 */
public class TwoSum {

    public static int[] solve(int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(numbers[0], 0);
        int idx1 = -1;
        int idx2 = -1;
        for (int index = 1; index < numbers.length; index++) {
            indexMap.put(numbers[index], index);
            int sub = target - numbers[index];
            Integer subIndex = indexMap.get(sub);
            if (subIndex != null && numbers[index] + numbers[subIndex] == target) {
                idx2 = index;
                idx1 = subIndex;
                break;
            }
        }

        return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
    }

    public static void main(String[] args) {

    }
}
