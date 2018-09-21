package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.greed.MinimumTime;
import org.junit.Test;

public class MinimumTimeTest {

    @Test
    public void test() {
        MinimumTime case1 = new MinimumTime(10, 110);
        case1.apps(1, 1,
                        30, 50);
        print(case1);

        MinimumTime case2 = new MinimumTime(10, 110);
        case1.apps(1, 1,
                50, 30);
        print(case2);

        MinimumTime case3 = new MinimumTime(1, 6);
        case1.apps(10, 3,
                20, 4);
        print(case3);

    }

    void print(MinimumTime minimumTime) {
        MinimumTime.Memory memory = minimumTime.run();
        if ( memory.getTime() < 0 ) {
            System.out.println(-1);
        } else {
            System.out.println("스마트폰의 최소 실행시간 : " + memory.getTime());
        }
    }
}
