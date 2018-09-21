package com.github.jarviskim.algorithm.boj.a1874_StackSequence;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class StackSequence {

    public static String solve(int... sequence) {
        int n = sequence.length;
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Integer> sequenceQueue = new LinkedList(IntStream.of(sequence).boxed().collect(Collectors.toList())) ;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stringBuilder.append("+");

        for ( int i = 2; i <= n;  ) {
            if ( !stack.isEmpty() && stack.peek().equals(sequenceQueue.peek()) ) {
                stack.poll();
                sequenceQueue.poll();
                stringBuilder.append("-");
            } else {
                stack.push(i++);
                stringBuilder.append("+");
            }

        }

        while ( !stack.isEmpty() ) {
            if ( stack.peek().equals(sequenceQueue.peek()) ) {
                stack.poll();
                sequenceQueue.poll();
                stringBuilder.append("-");
            } else {
                return "NO";
            }
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sequence = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            sequence[ i ] = scanner.nextInt();
        }

        String result = solve(sequence);
        if ( result.equals("NO") ) {
            System.out.println(result);
        } else {
            String[] results = result.split("");
            for ( String s : results ) {
                System.out.println(s);
            }
        }
    }
}
