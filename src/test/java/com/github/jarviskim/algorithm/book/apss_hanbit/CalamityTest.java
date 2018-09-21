package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.calamity.Calamity;
import org.junit.Assert;
import org.junit.Test;

public class CalamityTest {

    @Test
    public void test() {
        int x = 2;
        String[] map = new String[] {
                "FOOOE",
                "OOOOO",
                "OOOOO",
                "OOOOO",
                "YOFFO"
        };
        Calamity calamity = new Calamity(x, map);
        Calamity.MoveHistory moveHistory = calamity.findLoad();
        if ( moveHistory.escaped() ) {
            System.out.println(moveHistory.getCount());
            System.out.println(moveHistory.historyToString());
        } else {
            System.out.println("not escaped");
        }

        Assert.assertEquals(8, moveHistory.getCount());
        Assert.assertEquals("UURURRUR", moveHistory.historyToString());
    }
}
