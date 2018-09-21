package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a1005_AcmCraft.AcmCraft2;
import org.junit.Assert;
import org.junit.Test;

public class AcmCraft2Test {

    @Test
    public void test() {
        AcmCraft2.Node[] nodes = new AcmCraft2.Node[ 4 ];
        nodes[ 0 ] = new AcmCraft2.Node(0, 10);
        nodes[ 1 ] = new AcmCraft2.Node(1, 1);
        nodes[ 2 ] = new AcmCraft2.Node(2, 100);
        nodes[ 3 ] = new AcmCraft2.Node(3, 10);

        nodes[ 2 - 1 ].addNode(nodes[ 1 - 1]);
        nodes[ 3 - 1 ].addNode(nodes[ 1 - 1]);
        nodes[ 4 - 1 ].addNode(nodes[ 2 - 1]);
        nodes[ 4 - 1 ].addNode(nodes[ 3 - 1]);

        Assert.assertEquals(120, AcmCraft2.solve(nodes, 4 - 1));


        nodes = new AcmCraft2.Node[ 8 ];
        nodes[ 0 ] = new AcmCraft2.Node(0, 10);
        nodes[ 1 ] = new AcmCraft2.Node(1, 20);
        nodes[ 2 ] = new AcmCraft2.Node(2, 1);
        nodes[ 3 ] = new AcmCraft2.Node(3, 5);
        nodes[ 4 ] = new AcmCraft2.Node(4, 8);
        nodes[ 5 ] = new AcmCraft2.Node(5, 7);
        nodes[ 6 ] = new AcmCraft2.Node(6, 1);
        nodes[ 7 ] = new AcmCraft2.Node(7, 43);

        nodes[ 2 - 1 ].addNode(nodes[ 1 - 1]);
        nodes[ 3 - 1 ].addNode(nodes[ 1 - 1]);
        nodes[ 4 - 1 ].addNode(nodes[ 2 - 1]);
        nodes[ 5 - 1 ].addNode(nodes[ 2 - 1]);
        nodes[ 6 - 1 ].addNode(nodes[ 3 - 1]);
        nodes[ 7 - 1 ].addNode(nodes[ 5 - 1]);
        nodes[ 7 - 1 ].addNode(nodes[ 6 - 1]);
        nodes[ 8 - 1 ].addNode(nodes[ 7 - 1]);

        Assert.assertEquals(39, AcmCraft2.solve(nodes, 7 - 1));

    }
}
