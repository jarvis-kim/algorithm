package com.github.jarviskim.algorithm.book.apss_insignht.divide;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 울타리 잘라내기 (난이도 : 중)
 * 시간 복잡도 : O(nlogn)
 *
 * 문제 : 주어진 울타리에서 인접해있는 가장 넓은 직사각형 찾기
 * 전략 : 분할정복
 *   반으로 나누어, 왼쪽에 최대 넓이가 있거나, 오른쪽에 최대 넓이가 있거나, 왼쪽과 오른쪽에 걸쳐 있을수 있다.
 *
 * 다른 방법으로 풀기는 19장 스택 결합으로 풀기, 25장 상호 배타적 집합으로 풀기
 */
public class Fence {

    public int solve(int[] heights) {
        return solve(heights, 0, heights.length - 1);
    }

    public int solve(int[] heights, int first, int last) {
        if (last - first <= 0) {
            return heights[first];
        }

        int mid = (first + last) / 2;

        int leftArea = solve(heights, first, mid);
        int rightArea = solve(heights, mid + 1, last);
        int centerArea = centerArea(heights, first, last);

        return max(max(leftArea, rightArea), centerArea);
    }

    private int centerArea(int[] heights, int first, int last) {
        int mid = (first + last) / 2;
        int left = mid;
        int right = mid + 1;
        int minHeight = min(heights[left], heights[right]);
        int area = minHeight * 2;
        while (first < left && right < last) {
            minHeight = heights[left - 1] < heights[right + 1] ?
                    min(minHeight, heights[++right]) :
                    min(minHeight, heights[--left]);
            area = max(area, (right - left + 1) * minHeight);
        }

        while (first < left) {
            minHeight = min(minHeight, heights[--left]);
            area = max(area, (right - left + 1) * minHeight);
        }

        while (right < last) {
            minHeight = min(minHeight, heights[++right]);
            area = max(area, (right - left + 1) * minHeight);
        }

        return area;
    }

}
