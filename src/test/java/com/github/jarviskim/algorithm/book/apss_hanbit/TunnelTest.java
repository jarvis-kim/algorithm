package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.tunnel.Tunnel;
import org.junit.Assert;
import org.junit.Test;

public class TunnelTest {

    @Test
    public void test() {
        int result;

        /* Case 1 */
        Tunnel tunnel1 = new Tunnel(75, 30, 100, 38, 50, 51, 52, 20, 81, 5);

        result = tunnel1.minimumHeight(1, 10);
        Assert.assertEquals(5, result);
        System.out.println(result);

        result = tunnel1.minimumHeight(3, 5);
        Assert.assertEquals(38, result);
        System.out.println(result);

        result = tunnel1.minimumHeight(6, 9);
        Assert.assertEquals(20, result);
        System.out.println(result);

        result = tunnel1.minimumHeight(8, 10);
        Assert.assertEquals(5, result);
        System.out.println(result);

        System.out.println();

        /* Case 2 */
        Tunnel tunnel2 = new Tunnel(67, 74, 10, 8, 81);

        result = tunnel2.minimumHeight(1, 5);
        Assert.assertEquals(8, result);
        System.out.println(result);

        result = tunnel2.minimumHeight(1, 3);
        Assert.assertEquals(10, result);
        System.out.println(result);

    }
}
