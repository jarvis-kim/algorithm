package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1325_Hacking.Hacking;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class HackingTest {

    @Test
    public void test() {

        Hacking.NodeFactory nodeFactory = new Hacking.NodeFactory(5);
        nodeFactory
                .pair(3, 1)
                .pair(3, 2)
                .pair(4, 3)
                .pair(5, 3);
        List<Hacking.Node> leaf = nodeFactory.toLeafNodes();
        assertArrayEquals(new int[] { 1, 2 }, Hacking.solve(leaf));
    }

    @Test
    public void test2() {

        Hacking.NodeFactory nodeFactory = new Hacking.NodeFactory(5);
        nodeFactory
                .pair(3, 1)
                .pair(3, 2)
                .pair(4, 3)
                .pair(5, 3)
                .pair(5, 2);
        List<Hacking.Node> leaf = nodeFactory.toLeafNodes();
        assertArrayEquals(new int[] { 1, 2 }, Hacking.solve(leaf));
    }


    /**
     * 싸이클이 존재하는 경우
     */
    @Test
    public void test3() {

        Hacking.NodeFactory nodeFactory = new Hacking.NodeFactory(5);
        nodeFactory
                .pair(3, 2)
                .pair(2, 1)
                .pair(1, 3);
        List<Hacking.Node> leaf = nodeFactory.toLeafNodes();
        assertArrayEquals(new int[] { 1, 2, 3 }, Hacking.solve(leaf));
    }
}
