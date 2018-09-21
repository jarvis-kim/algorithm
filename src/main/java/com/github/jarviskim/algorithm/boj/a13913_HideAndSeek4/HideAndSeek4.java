package com.github.jarviskim.algorithm.boj.a13913_HideAndSeek4;

import java.util.*;

/**
 *  문제 : 숨바꼭질4
 *  BFS를 이용. 숨바꼭질1에서는 이동횟수만 출력. 숨바꼭질4는 경로를 출력한다.
 * 출처 : https://www.acmicpc.net/problem/13913
 */
public class HideAndSeek4 {

    static final int MAX = 1000000;
    static final int MIN = 0;

    public static int[] solve(int x, int k) {
        Queue<Integer> queue = new LinkedList<>();

        int length = MAX ;
        boolean[] visited = new boolean[ length ];
        int[] via = new int[ length ];

        queue.add(x);
        visited[ x ] = true;

        while ( !queue.isEmpty()  ) {
            int position = queue.poll();

            if ( position - 1 >= MIN && !visited[ position - 1 ] ) {
                via[ position - 1 ] = position;
                visited[ position - 1 ] = true;
                queue.add(position - 1);
            }

            if ( position + 1 < MAX && !visited[ position + 1 ] ) {
                via[ position + 1 ] = position;
                visited[ position + 1 ] = true;
                queue.add(position + 1);
            }

            if ( position * 2 < MAX && !visited[ position * 2 ]) {
                via[ position * 2 ] = position;
                visited[ position * 2 ] = true;
                queue.add(position * 2);
            }
        }

        List<Integer> minimumVia = new ArrayList<>();
        minimumVia.add(k);
        int next = k;
        while ( next != x ) {
            minimumVia.add(via[ next ]);
            next = via[ next ];
        }

        Collections.reverse(minimumVia);

        return minimumVia.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] result = solve(x, y);
        System.out.println(result.length - 1);
        for ( int n : result ) {
            System.out.printf(n + " ");
        }
        System.out.println();

    }

}
