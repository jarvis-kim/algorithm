package com.github.jarviskim.algorithm.mailprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 두개의 정렬된(sorted) 정수 링크드리스트(linked list)가 주어지면, 두 리스트를 합친 정렬된 링크드리스트를 만드시오.
 *
 * 예제)
 * Input: 1->2->3, 1->2->3
 * Output: 1->1->2->2->3->3
 *
 * Input: 1->3->5->6, 2->4
 * ﻿Output: 1->2->3->4->5->6
 */
public class Quiz16 {

    public static int[] mergeKeepSorted(int[] list1, int[] list2) {
        List<Integer> mergedList = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        while (index1 < list1.length && index2 < list2.length) {
            if (list1[index1] < list2[index2]) {
                mergedList.add(list1[index1++]);
            } else {
                mergedList.add(list2[index2++]);
            }
        }

        for (; index1 < list1.length; index1++) {
            mergedList.add(list1[index1]);
        }

        for (; index2 < list2.length; index2++) {
            mergedList.add(list2[index2]);
        }

        return mergedList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] input_1_1 = {1, 2, 3};
        int[] input_1_2 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeKeepSorted(input_1_1, input_1_2)));

        int[] input_2_1 = {1,3,5,6};
        int[] input_2_2 = {2,4};
        System.out.println(Arrays.toString(mergeKeepSorted(input_2_1, input_2_2)));

    }
}
