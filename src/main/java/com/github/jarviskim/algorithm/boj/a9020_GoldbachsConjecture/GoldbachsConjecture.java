package com.github.jarviskim.algorithm.boj.a9020_GoldbachsConjecture;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GoldbachsConjecture {

    static class Eratos {
        private boolean notPrimeNumbers[];

        private int n;

        public Eratos(int n) {
            this.n = n;
            this.notPrimeNumbers = new boolean[ n + 1 ];
            init();
        }

        private void init() {
            final int root = (int) Math.sqrt(this.n);
            for ( int number = 2; number <= root; number++ ) {
                for ( int multiple = number * 2; multiple <= this.n; multiple += number ) {
                    this.notPrimeNumbers[ multiple ] = true;
                }
            }
        }

        public boolean isPrimeNumber(int n) {
            if ( 1 > n && n > this.n ) {
                throw new IllegalArgumentException("n is over. n is between 1 and " + this.n);
            }

            return !notPrimeNumbers[ n ];
        }
    }

    public static class GoldbachPartition {
        public GoldbachPartition(int number, int firstPrimeNumber, int secondPrimeNumber) {
            if ( number % 2 != 0 ) {
                throw new IllegalArgumentException("number is not even number");
            }

            /* check number equal sum of first and second */
            /* check first and second number is prime number */

            this.number = number;
            this.firstPrimeNumber = Math.min(firstPrimeNumber, secondPrimeNumber);
            this.secondPrimeNumber = Math.max(firstPrimeNumber, secondPrimeNumber);
        }

        private final int number;
        private final int firstPrimeNumber;
        private final int secondPrimeNumber;

        public int getNumber() {
            return number;
        }

        public int getFirstPrimeNumber() {
            return firstPrimeNumber;
        }

        public int getSecondPrimeNumber() {
            return secondPrimeNumber;
        }

        public int gap() {
            return this.getSecondPrimeNumber() - this.getFirstPrimeNumber();
        }

        public boolean greaterThan(GoldbachPartition target) {
            return this.gap() > target.gap();
        }

        @Override
        public boolean equals(Object o) {
            if ( this == o ) return true;
            if ( !(o instanceof GoldbachPartition) ) return false;
            GoldbachPartition partition = (GoldbachPartition) o;
            return number == partition.number &&
                    firstPrimeNumber == partition.firstPrimeNumber &&
                    secondPrimeNumber == partition.secondPrimeNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, firstPrimeNumber, secondPrimeNumber);
        }
    }

    private static Eratos eratos;

    public static void lookup(int n) {
        eratos = new Eratos(n);
    }

    public static GoldbachPartition solve(final int number) {
        if ( number % 2 != 0 ) {
            throw new IllegalArgumentException("number is not even number");
        }
//        for ( int number = 4; number <= n; number += 2 ) {
            GoldbachPartition partition = null;
            for ( int num = number - 1; num > 1; num-- ) {
                if ( eratos.isPrimeNumber(num) && eratos.isPrimeNumber(number - num) ) {
                    GoldbachPartition next = new GoldbachPartition(number, num, number - num);
                    if ( Objects.isNull(partition) ) {
                        partition = next;
                    } else if ( partition.greaterThan(next) ){
                        partition = next;
                    }
                }
            }

        return partition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numbers = new int[ n ];
        IntStream.range(0, n)
                .forEach(number -> {
                    numbers[ number ] = scanner.nextInt();
                });

        lookup(
                Arrays.stream(numbers)
                        .max()
                        .orElseThrow(() -> new RuntimeException("is max not exist"))
        );

        Arrays.stream(numbers)
                .forEach(number -> {
                    GoldbachPartition partition = solve(number);
                    System.out.printf("%d %d", partition.getFirstPrimeNumber(), partition.getSecondPrimeNumber());
                    System.out.println();
                });

    }
}
