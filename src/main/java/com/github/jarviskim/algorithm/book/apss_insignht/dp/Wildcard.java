package com.github.jarviskim.algorithm.book.apss_insignht.dp;

/**
 * 와일드 카드(중)
 * 문제 : 문자열 매치를 하는데, ?, *를 사용. ?는 한글자 대응, *는 0개 이상의 글자 대응
 */
public class Wildcard {

    private Boolean[][] memoization;
    private char[] pattern;
    private char[] str;

    public Wildcard(String pattern, String str) {
        this.pattern = pattern.toCharArray();
        this.str = str.toCharArray();
        this.memoization = new Boolean[this.pattern.length + 1][this.str.length + 1];
    }

    public boolean match(int patternIndex, int strIndex) {
        if (memoization[patternIndex][strIndex] != null) {
            return memoization[patternIndex][strIndex];
        }

        // 1. 각각 하나씩 맞는지 검사
        while (patternIndex < pattern.length &&  strIndex < str.length &&
                (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '?')) {
            patternIndex++;
            strIndex++;
        }

        // 2. 패턴의 끝에 도달하면, 문자열도 끝에 도달해야 매치
        if (pattern.length == patternIndex) {
            return memoization[patternIndex][strIndex] = (str.length == strIndex);
        }

        // 3. 패턴이 '*'인 경우, 나머지 문자를 검사 함
        if (pattern[patternIndex] == '*') {
            for (int skip = 0; patternIndex + skip < str.length; skip++) {
                // *패턴의 다음 문자열과, 현재 str의 문자부터 남은 문자열이 모두 같은지 검사 함(재귀 적으로)
                // 여기서 중복이 많이 발생되므로, 메모이제이션 적용.
                memoization[patternIndex][strIndex] = match(patternIndex + 1, strIndex + skip);
                if (memoization[patternIndex][strIndex]) {
                    return true;
                }
            }
        }

        return memoization[patternIndex][strIndex] = false;
    }

    public static boolean match(String pattern, String str) {
        return new Wildcard(pattern, str).match(0, 0);
    }

}
