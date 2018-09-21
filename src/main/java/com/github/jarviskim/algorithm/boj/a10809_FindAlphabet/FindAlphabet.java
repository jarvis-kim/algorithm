package com.github.jarviskim.algorithm.boj.a10809_FindAlphabet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  알파벳 찾기
 *  https://www.acmicpc.net/problem/10809
 */
public class FindAlphabet {

    private static final int a = 'a';

    private static final int z = 'z';

    public static int[] solve(String str) {
        char[] chars = str.toCharArray();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for ( int idx = chars.length - 1; idx >= 0; idx-- ) {
            indexMap.put(new Integer(chars[ idx ]), idx);
        }

        int[] alphabet = new int[ z - a + 1 ];
        for ( int index = 0; index < alphabet.length; index++ ) {
            Integer r = indexMap.get(index + a);
            alphabet[ index ] = r != null ? r.intValue() : -1;
        }

        return alphabet;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] result = solve(input);
        for ( int r : result ) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
