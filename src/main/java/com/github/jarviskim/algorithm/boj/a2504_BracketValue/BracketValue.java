package com.github.jarviskim.algorithm.boj.a2504_BracketValue;

import java.util.*;

/**
 * 괄호의 값
 * https://www.acmicpc.net/problem/2504
 * <p>
 * ( [ 를 만나면 스택에 0 1 을 넣은다.
 * ( [ 를 만났을 때 마지막도 ( [ 이거면 마지막 1을(or 마지막) pop하고 0 1 을 넣는다.
 * )를 만나면 마지막 숫자를 꺼내 곱한다(2or3). 그리고 마지막 숫자를 하나 더 빼서 더한다. 그 값을 다시 스택에 넣는다.2
 */
public class BracketValue {


    public static int solve(String bracket) {
        char[] brackets = bracket.toCharArray();

        Deque<Bracket> stack = new ArrayDeque<>();
        Deque<Integer> operandStack = new ArrayDeque<>();

        Bracket beforeBracket = null;

        operandStack.push(0);
        for ( char bracketChar : brackets ) {
            Bracket abstractBracket = BracketFactory.bracket(bracketChar);
            if ( abstractBracket == null ) {
                throw new IllegalArgumentException("괄호가 아니것이 포함됨.");
            }

            if ( abstractBracket.isLeft() ) {
                if ( stack.isEmpty() ) {
                }
                if ( beforeBracket != null && beforeBracket.isLeft() && abstractBracket.isLeft() ) {
                    operandStack.pop();
                    operandStack.push(0);
                }
                operandStack.push(1);
                stack.push(abstractBracket);
            } else if ( !abstractBracket.isLeft() ) {
                if ( stack.isEmpty() || !stack.peek().isLeft() || stack.peek().getMultiplyValue() != abstractBracket.getMultiplyValue() ) {
                    return 0;
                }

                int value = operandStack.pop() * abstractBracket.getMultiplyValue() + operandStack.pop();
                operandStack.push(value);
                stack.pop();
            }

            beforeBracket = abstractBracket;
        }

        return operandStack.size() == 1 ? operandStack.poll() : 0;
    }

    static class BracketFactory {

        private static Map<Character, Bracket> instances = new HashMap<>();

        static {
            instances.put('(', new BracketImpl(2, '(', true));
            instances.put(')', new BracketImpl(2, ')', false));
            instances.put('[', new BracketImpl(3, '[', true));
            instances.put(']', new BracketImpl(3, ']', false));
        }

        static Bracket bracket(char c) {
            return instances.get(c);
        }
    }

    interface Bracket {
        int getMultiplyValue();

        boolean isLeft();

        char getBracket();
    }

    static class BracketImpl implements Bracket {

        private final int value;

        private final char bracket;

        private final boolean left;

        public BracketImpl(int value, char bracket, boolean left) {
            this.value = value;
            this.bracket = bracket;
            this.left = left;
        }

        @Override
        public int getMultiplyValue() {
            return value;
        }

        @Override
        public boolean isLeft() {
            return left;
        }

        @Override
        public char getBracket() {
            return bracket;
        }

        @Override
        public boolean equals(Object o) {
            if ( this == o ) return true;
            if ( !(o instanceof BracketImpl) ) return false;
            BracketImpl bracket1 = (BracketImpl) o;
            return value == bracket1.value &&
                    bracket == bracket1.bracket &&
                    left == bracket1.left;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, bracket, left);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solve(str));
    }

}