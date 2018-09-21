package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.tree.*;
import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void addTest() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(10);
        binaryTree.add(7);

        Assert.assertEquals(6, binaryTree.size());

        PrintAction<Integer> action = new PrintAction<>();

        System.out.print("Pre order : ");
        binaryTree.order(new PreOrderVisitor<>(action));
        System.out.println();

        System.out.print("In order : ");
        binaryTree.order(new InOrderVisitor<>(action));
        System.out.println();

        System.out.print("Post order : ");
        binaryTree.order(new PostOrderVisitor<>(action));
        System.out.println();

        System.out.print("Level order : ");
        binaryTree.order(new LevelOrderVisitor<>(action));
        System.out.println();
    }
}
