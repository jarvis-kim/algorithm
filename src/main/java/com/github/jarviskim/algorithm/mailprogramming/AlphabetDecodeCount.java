package com.github.jarviskim.algorithm.mailprogramming;


/**
 * 영어 알파벳은 다음과 같이 표기할 수 있습니다.
 a = 1, b = 2, ... y = 25, z = 26.

 숫자로 이루어진 문자열이 주어졌을때, 몇가지 방법으로 해독이 가능한지 구하시오.

 예)
 input: "111"
 output: 3 // "aaa", "ak", "ka"

 # 애매한것은 127의 경우 abg와 a가 나오는데 z(27)을 넘어가는 경우를 어떻게 처리해야할지 이해가 안감.
 */
public class AlphabetDecodeCount {

    static final int START_ALPHABET = 1;
    static final int END_ALPHABET = 26;

    public AlphabetDecodeCount() {
    }

    static int countOfDecodeNumber(int number) {
        int length = (int) (Math.log10(number) + 1);

        int[] d = new int[length + 1];
        d[0] = d[1] = 1;

        int num = number % (int) Math.pow(10, length - 1);
        int before = 0;
        for (int i = 2; i <= length; i++) {
            int current = (int) (num / Math.pow(10, length - i));
            d[i] += d[i - 1];

            int alphabetNumber = before * 10 + current;
            if (START_ALPHABET <= alphabetNumber && alphabetNumber <= END_ALPHABET) {
                d[i] += d[i - 2];
            }

            num = (int) (num % Math.pow(10, length - i));
            before = current;
        }

        return d[length];
    }

    public static void main(String[] args) {
        System.out.println(countOfDecodeNumber(111));
    }
}
