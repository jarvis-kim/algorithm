package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a2606_Virus.Virus;
import org.junit.Assert;
import org.junit.Test;

public class VirusTest {

    @Test
    public void test() {
        Virus.NodeFactory factory = new Virus.NodeFactory();
        factory.createNodeAndAddChild(1, 2);
        factory.createNodeAndAddChild(2, 3);
        factory.createNodeAndAddChild(1, 5);
        factory.createNodeAndAddChild(5, 2);
        factory.createNodeAndAddChild(5, 6);
        factory.createNodeAndAddChild(4, 7);

        Virus.Node node = factory.createNode(1);

        Assert.assertEquals(4, Virus.solve(node));
    }

    @Test
    public void test2() {
        Virus.NodeFactory factory = new Virus.NodeFactory();
        factory.createNodeAndAddChild(1, 6);
        factory.createNodeAndAddChild(2, 3);
        factory.createNodeAndAddChild(1, 2);
        factory.createNodeAndAddChild(1, 5);
        factory.createNodeAndAddChild(5, 6);
        factory.createNodeAndAddChild(1, 3);
        factory.createNodeAndAddChild(8, 9);
        factory.createNodeAndAddChild(5, 2);
        factory.createNodeAndAddChild(4, 7);

        Virus.Node node = factory.createNode(1);

        Assert.assertEquals(4, Virus.solve(node));
    }

    @Test
    public void test3() {
        Virus.NodeFactory factory = new Virus.NodeFactory();
        factory.createNodeAndAddChild(1, 2);
        factory.createNodeAndAddChild(2, 3);
        factory.createNodeAndAddChild(1, 5);
        factory.createNodeAndAddChild(5, 2);
        factory.createNodeAndAddChild(6, 5);
        factory.createNodeAndAddChild(4, 7);

        Virus.Node node = factory.createNode(1);

        Assert.assertEquals(4, Virus.solve(node));
    }
}
