package com.github.jarviskim.algorithm.mailprogramming;

public class MaxTwo {

    public static int solve(int[] array){
        int first = array[0];
        Integer second = null;
        for (int i = 1; i < array.length; i++) {
            if (first != array[i]) {
                if (first < array[i]) {
                    second = first;
                    first = array[i];
                } else if (second == null || second < array[i]) {
                    second = array[i];
                }
            }
        }
        if (second == null) {
            throw new RuntimeException("Does not exist");
        }

        return second;
    }

    public static void main(String[] args) {
        int[] array1 = {10, 5, 4, 3, -1};
        int[] array2 = {3,3,3};
        int[] array3 = {7, 3, 5, 8};

        System.out.println(solve(array1));
        try {
            System.out.println(solve(array2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(solve(array3));
    }
}
