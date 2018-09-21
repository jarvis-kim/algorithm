package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.subtotal.MaximumContinuousSubtotal;
import org.junit.Assert;
import org.junit.Test;

public class MaximumContinuousSubtotalTest {

    @Test
    public void test() {
        /* Case 1 */
        MaximumContinuousSubtotal maximumContinuousSubtotal1 = new MaximumContinuousSubtotal(-1, 5, 2, -2, 8);
        Assert.assertEquals(13, maximumContinuousSubtotal1.maxSubtotal());
        System.out.println(maximumContinuousSubtotal1.maxSubtotal());


        /* Case 2*/
        int[] inputs = new int[] { -13920, 2341, -14904, 12152, 8208, -8190, -9494, 10792, -5129, 2421, -3316, -4203, 4224, -7460,
                                    8801, -459, 8447, -14983, -7562, 6515, 786, 12579, -7659, -5633, -8847, 3899, 3178, -1944, -1982,
                                    8674, 2916, -18964, -3429, -3223, -13986, 1935, -3774, -9719, -18945, 1898, 10935, -7211, -11682,
                                    -4026, -2956, -16660, -14230, -6295, -19085, -3597 };
        MaximumContinuousSubtotal maximumContinuousSubtotal2 = new MaximumContinuousSubtotal(inputs);
        Assert.assertEquals(20360, maximumContinuousSubtotal2.maxSubtotal());
        System.out.println(maximumContinuousSubtotal2.maxSubtotal());


        /* Case 3*/
        MaximumContinuousSubtotal maximumContinuousSubtotal3 = new MaximumContinuousSubtotal(-3, -1, -2);
        Assert.assertEquals(-1, maximumContinuousSubtotal3.maxSubtotal());
        System.out.println(maximumContinuousSubtotal3.maxSubtotal());
    }
}
