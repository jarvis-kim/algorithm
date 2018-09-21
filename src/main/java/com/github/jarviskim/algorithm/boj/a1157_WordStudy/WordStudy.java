package com.github.jarviskim.algorithm.boj.a1157_WordStudy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordStudy {

    public static char solve(String word) {
        word = word.toUpperCase().trim();
        char[] chars = word.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for ( char c : chars ) {
            Integer count = map.get(c);
            if ( count == null ) {
                count = new Integer(0);
            }
            map.put(c, count.intValue() + 1);
        }

        List<Map.Entry<Character, Integer>> collect =  map.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())).collect(Collectors.toList());

        if ( collect.size() == 1 ) {
            return collect.get(0).getKey();
        }

        Map.Entry<Character, Integer> max = collect.get(0);
        Map.Entry<Character, Integer> max2 = collect.get(1);

        if ( max.getValue().equals(max2.getValue())  ) {
            return '?';
        }

        return max.getKey();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextLine()));
    }
}
