package com.github.jarviskim.algorithm.mailprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LookAndSay {

    public static void main(String[] args) {
        new LookAndSay().solve(5);
    }

    void solve(int n) {
        int[] arr = {1};
        for (int index = 0; index < n; index++) {
            printSequnece(arr);
            System.out.print(" - ");
            printDescriptonSequence(arr);
            System.out.println();
            arr = solve(arr);
        }
    }

    int[] solve(int[] array) {
        int number = array[0];
        List<Integer> newArray = new ArrayList<>();
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == number) {
                count++;
            } else {
                newArray.add(count);
                newArray.add(number);
                count = 1;
                number = array[i];
            }
        }
        newArray.add(count);
        newArray.add(number);
        return newArray.stream().mapToInt(value -> value).toArray();
    }

    void printSequnece(int[] array) {
        String sequence = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.print(sequence);
    }

    void printDescriptonSequence(int[] array) {
        int number = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == number) {
                count++;
            } else {
                System.out.printf("%d개의 %d, ", count, number);
                count = 1;
                number = array[i];
            }
        }
        System.out.printf("%d개의 %d, ", count, number);
    }
}
