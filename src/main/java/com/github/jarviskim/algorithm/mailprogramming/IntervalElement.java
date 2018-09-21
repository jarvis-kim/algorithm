package com.github.jarviskim.algorithm.mailprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

/**
 *
 * 간격(interval)로 이루어진 배열이 주어지면, 겹치는 간격 원소들을 합친 새로운 배열을 만드시오. 간격은 시작과 끝으로 이루어져 있으며 시작은 끝보다 작거나 같습니다.
 *
 * 예제)
 *
 * Input: {{2,4}, {1,5}, {7,9}}
 * Output: {{1,5}, {7,9}}
 *
 * Input: {{3,6}, {1,3}, {2,4}}
 * Output: {{1,6}}
 */
public class IntervalElement {

    static class Element {
        int start;
        int end;

        public Element(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Element(Element element) {
            this.start = element.start;
            this.end = element.end;
        }

        @Override
        public String toString() {
            return "{" + start + "," + end + "}";
        }
    }

    public static List<Element> solve(Element[] elements) {
        List<Element> answer = new ArrayList<>();
        Element current = null;
        for (Element element : elements) {
            if (nonNull(current) && current.end > element.start) {
                current.start = Math.min(current.start, element.start);
                current.end = Math.max(current.end, element.end);
            } else {
                current = new Element(element);
                answer.add(current);
            }
        }

        return answer;
    }

    private static String toString(List<Element> elements) {
        return elements
                .stream()
                .map(Element::toString)
                .collect(Collectors.joining(",", "{", "}"));
    }

    public static void main(String[] args) {
        System.out.println(toString(solve(new Element[]{new Element(2, 4), new Element(1, 5), new Element(7, 9)})));
        System.out.println(toString(solve(new Element[]{new Element(3, 6), new Element(1, 3), new Element(2, 4)})));
    }
}
