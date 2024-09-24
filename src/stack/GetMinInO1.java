package com.company.stack;

import java.util.Stack;

public class GetMinInO1 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static int min = Integer.MAX_VALUE;

    public static void mainFn() {
        push(6);
        push(8);
        push(5);
        push(3);
        int x = pop();
        push(10);
        x = pop();
        x = pop();
        x = pop();
        x = pop();
    }

    private static void push(int x) {
        if (x > min) {
            stack1.push(x);
        } else {
            stack1.push(x);
            stack2.push(x);
            min = x;
        }
    }

    private static int pop() {
        int x = stack1.pop();
        if (x == min) {
            stack2.pop();
            min = stack2.peek();
        }
        return x;
    }

    private static int getMin() {
        return stack2.peek();
    }

    private static int getTop() {
        return stack1.peek();
    }
}

