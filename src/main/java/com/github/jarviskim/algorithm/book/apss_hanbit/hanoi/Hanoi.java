package com.github.jarviskim.algorithm.book.apss_hanbit.hanoi;

/**
 * 1차. 오답이였음.
 */
public class Hanoi {

    public int run(int n, int from, int to, int via) {
        if ( n == 0 ) {
            return 1;
        }

        int count = 0;
        count += run(n - 1, from, via, to);
        process(from, to);
        count += run(n - 1, via, to, from);

        return count;
    }


    private void process(int a, int b) {
        System.out.println(a + "에서 " + b + "로 이동");
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        int count = hanoi.run(3, 1, 2, 3);
        System.out.println("이동 횟수 : " + (count - 1));
    }
}
