package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.greed.MinimumTimeOfBook;
import org.junit.Test;

public class MinimumTimeOfBookTest {
    @Test
    public void test() {
        MinimumTimeOfBook case1 = new MinimumTimeOfBook(10, 110);
        case1.apps(1, 1,
                30, 50);
        print(case1);

        MinimumTimeOfBook case2 = new MinimumTimeOfBook(10, 110);
        case2.apps(1, 1,
                50, 30);
        print(case2);

        MinimumTimeOfBook case3 = new MinimumTimeOfBook(1, 6);
        case3.apps(10, 3,
                20, 4);
        print(case3);

        MinimumTimeOfBook case4 = new MinimumTimeOfBook(1, 11);
        case4.apps(4, 3,
                5, 4,
                7, 5);
        print(case4);


    }

    void print(MinimumTimeOfBook minimumTimeOfBook) {
        int time = minimumTimeOfBook.minimumTime();
        if ( time < 0 ) {
            System.out.println(-1);
        } else {
            System.out.println("스마트폰의 최소 실행시간 : " + time);
        }
    }
}
