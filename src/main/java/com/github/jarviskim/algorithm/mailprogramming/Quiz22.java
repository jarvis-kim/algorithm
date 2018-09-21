package com.github.jarviskim.algorithm.mailprogramming;

/**
 * 정렬(sort)된 정수 배열과 정수 n이 주어지면, 배열안에 n이 있는지 체크하시오. 시간복잡도를 최대한 최적화하시오.

 예제)
 Input: [1, 2, 3, 7, 10], 7
 Output: true

 Input: [-5, 3, 0, 1], 0
 Output: true

 Input: [1, 4, 5, 6, 8, 9], 10
 Output: false
 */
public class Quiz22 {

    public static void main(String[] args) {


    }

    public static boolean search(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length );
    }

    private static boolean binarySearch(int[] arr, int target, int start, int end) {
        if (start >= end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return true;
        }
        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        } else {
            return binarySearch(arr, target, start, mid);
        }
    }
}
