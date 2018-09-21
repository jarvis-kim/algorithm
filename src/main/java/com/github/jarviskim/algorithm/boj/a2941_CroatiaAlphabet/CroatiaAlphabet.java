package com.github.jarviskim.algorithm.boj.a2941_CroatiaAlphabet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 크로아티아 알파벳
 * https://www.acmicpc.net/problem/2941
 */
public class CroatiaAlphabet {

    private static final Map<Character, char[][]> CROATIA_ALPHABET = new HashMap<>();
    static {
        CROATIA_ALPHABET.put('c', new char[][] { "c=".toCharArray(), "c-".toCharArray() });
        CROATIA_ALPHABET.put('d', new char[][] { "dz=".toCharArray(), "d-".toCharArray() });
        CROATIA_ALPHABET.put('l', new char[][] { "lj".toCharArray() });
        CROATIA_ALPHABET.put('n', new char[][] { "nj".toCharArray() });
        CROATIA_ALPHABET.put('s', new char[][] { "s=".toCharArray() });
        CROATIA_ALPHABET.put('z', new char[][] { "z=".toCharArray() });
    }

    public static int solve(String str) {
        int count = 0;

        char[] chars = str.toCharArray();
        int jump;
        int index = 0;
        while ( index < chars.length ) {
            jump = 1;
            if ( CROATIA_ALPHABET.get(chars[ index ]) != null ) {
                jump = match(chars, index, CROATIA_ALPHABET.get(chars[ index ]));
            }
            
            index += jump;
            count++;
        }

        return count;
    }

    static int match(char[] source, int sourceIndex, char[][] matchChars) {

        for ( int matchRow = 0; matchRow < matchChars.length; matchRow++ ) {
            if ( sourceIndex + matchChars[ matchRow ].length > source.length ) {
                continue;
            }

            int matchCount = 0;
            for ( int index = 0; index < matchChars[ matchRow ].length; index++ ) {
                if ( source[ index + sourceIndex ] == matchChars[ matchRow ][ index ] ) {
                    matchCount++;
                } else {
                    break;
                }
            }
            
            if ( matchCount == matchChars[ matchRow ].length ) {
                return matchCount;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        System.out.println(solve(str));
    }
}
