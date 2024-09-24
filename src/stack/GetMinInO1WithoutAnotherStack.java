package stack;

import java.util.Stack;

public class GetMinInO1WithoutAnotherStack {
    static Stack<Integer> stack = new Stack<>();
    static int min = Integer.MAX_VALUE;

    public static void mainFn() {

    }

    private static int pop() {
        int x = stack.pop();
        int y = min;
        if (x> min) {
            return x;
        } else {
            min = 2*y - x;
        }
        return y;
    }

    private static void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
        } else {
            if (x > min) {
                stack.push(x);
            } else {
                stack.push(2*x - min);
                min = x;
            }
        }
    }

    private static int getMin() {
        return min;
    }
}


