package com.github.jarviskim.algorithm.book.apss_hanbit.tree;

public interface Visited<T extends Comparable<T>> {

    void doAction(T t);
}
