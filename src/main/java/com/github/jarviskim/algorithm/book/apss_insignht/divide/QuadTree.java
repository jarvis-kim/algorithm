package com.github.jarviskim.algorithm.book.apss_insignht.divide;

/**
 * 쿼드 트리 (알고리즘 문제해결 전략 p189)
 * 문제 : 쿼드 트리(이미지)를 상하 반전 시키기
 * 전략 : 분할 정복
 */
public class QuadTree {

    public String reverse(String quadTree) {
        return reverse(quadTree.toCharArray(), 0);
    }

    String reverse(char[] quadTree, int pos) {
        if (quadTree[pos] != 'x') {
            return String.valueOf(quadTree[pos]);
        } else {
            String one = reverse(quadTree, 1 + pos);
            String two = reverse(quadTree, 1 + pos + one.length());
            String three = reverse(quadTree, 1 + pos + one.length() + two.length());
            String four = reverse(quadTree, 1 + pos + one.length() + two.length() + three.length());

            return "x" + three + four + one + two;
        }
    }

}
