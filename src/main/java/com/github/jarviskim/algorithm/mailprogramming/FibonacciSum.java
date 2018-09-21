package com.github.jarviskim.algorithm.mailprogramming;

/**
 * 피보나치 배열은 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다. 정수 N이 주어지면, N보다 작은 모든 짝수 피보나치 수의 합을 구하여라.
 */
public class FibonacciSum {

    public static int sum(int n) {
        int sum = 0;
        int first = 0;
        int second = 1;
        int fibonacci = first + second;
        while ( fibonacci <= n ) {
            fibonacci = first + second;
            first = second;
            second = fibonacci;
            if ( fibonacci % 2 == 0 ) {
                sum += fibonacci;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println(sum(12));
    }
}
