package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2150_StronglyConnectedComponent.StronglyConnectedComponent;
import org.junit.Assert;
import org.junit.Test;

public class StronglyConnectedComponentTest {

    @Test
    public void test() {
        StronglyConnectedComponent.Scc scc = new StronglyConnectedComponent.Scc(7);
        scc.edge(1, 4)
                .edge(4, 5)
                .edge(5, 1)
                .edge(1, 6)
                .edge(6, 7)
                .edge(2, 7)
                .edge(7, 3)
                .edge(3, 7)
                .edge(7, 2);
        int[][] result = scc.solve();
        int[][] answer = new int[][] {
                new int[] { 1, 4, 5 },
                new int[] { 2, 3, 7 },
                new int[] { 6 }
        };
        Assert.assertArrayEquals(answer, result);
    }
}
