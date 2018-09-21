package com.github.jarviskim.algorithm.mailprogramming;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * 길이가 같은 두 문자열(string) A 와 B가 주어지면, A 가 B 로 1:1 암호화 가능한지 찾으시오.
 *
 * 예제)
 Input: “EGG”, “FOO”
 Output: True // E->F, G->O

 Input: “ABBCD”, “APPLE”
 Output: True // A->A, B->P, C->L, D->E

 Input: “AAB”, “FOO”
 Output: False
 */
public class Quiz11 {

    public static boolean validEncoded(String str1, String str2) {
        if (str1.length() != str2.length() || str1.length() == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();

        Iterator<Integer> char2 = str2.chars().iterator();
        return str1.chars()
                .filter(x -> char2.hasNext())
                .allMatch(x -> {
                    Integer to = char2.next();
                    return Objects.equals(map.computeIfAbsent(x, i -> to), to);
                });
    }

    public static void main(String[] args) {
        System.out.println(validEncoded("EGG", "FOO"));
        System.out.println(validEncoded("ABBCD", "APPLE"));
        System.out.println(validEncoded("AAB", "FOO"));
    }
}
