package com.github.jarviskim.algorithm.programmers;

/**
 * 3xN 타일링
 *
 * https://programmers.co.kr/learn/challenge_codes/64
 *
 * 기존 블럭에서 새로 채울 블럭은 3가지가 추가된다.
 * 그러므로 기존 채워진 블럭에 x 3을 한다.
 * 또다른 케이스가 있다. N = 4일때 2가지가 케이스가 추가되는데, 이전 블럭이 꽉채우지 않는 상태의 블럭이 두가지가 있다.
 * ex) || == == ||      == == == ==
 *     || == == ||      || == == ||
 *     == == == ==      || == == ||
 *
 * N = 4일땐 이전 3가지 x 3 + 2(위에 두가지 케이스)
 * 그런데 처음에 잘못생각한게 무조건 이전 케이스 d[i - 2] * 2 인줄 알았는데,
 * https://m.blog.naver.com/PostView.nhn?blogId=dldbdgml99&logNo=220002222967&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
 * 를 보고 아니다라는것을 알았다.
 *
 * 2가지 케이스가 추가되는 N=4일때는 처음 2가지이고, 다음 N=6일때는 N=2를 꽉채울때랑, + 2 가지가 있다. N=2를  꽉채운 상태에서 두가지케이스가 존재하므로 3 x 2 + 2이다.
 * 마잔가지로 N=8일때는 N=4를 꽉채운 상태에서 2가지, N=2를 꽉채운 상태에서 2가지, 그리고 + 2이다.
 * 그러면 N=8일때는 2가지 케이스에 대하여 = (3 x 2) + (11 x 2) + 2 이다.
 *
 * 그러므로 점화식은 d[i] = (d[i-2] * 3) + 누적(d[2 ~ i-2 ] * 2 + 2) 이다.
 */
class N3Tiling {
    static final int MOD = 100000;

    public int tiling(int n) {
        if (n % 2 == 1) {
            return 0;
        }

        if (n == 2) {
            return 3;
        }

        int[] d = new int[n + 1];
        int[] twoCase = new int[n + 1];
        d[2] = 3;
        twoCase[2] = 2;
        for (int i = 4; i <= n; i += 2) {
            d[i] = (d[i - 2] * 3 + twoCase[i - 2]) % MOD;
            twoCase[i] = twoCase[i - 2] + (d[i - 2] * 2) % MOD;
        }

        return d[n];
    }

//    int twoCase(int[] d, int n) {
//        int sum = 2;
//        for (int i = 2; i < n; i += 2) {
//            sum += d[i] * 2;
//        }
//        return sum;
//    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        N3Tiling t = new N3Tiling();
        System.out.println(t.tiling(2));
        System.out.println(t.tiling(4));
        System.out.println(t.tiling(6));
        System.out.println(t.tiling(8));
        System.out.println(t.tiling(10));
        System.out.println(t.tiling(12));
    }
}

