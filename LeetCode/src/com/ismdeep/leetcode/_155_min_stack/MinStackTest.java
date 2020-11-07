package com.ismdeep.leetcode._155_min_stack;

import java.util.Stack;

class MinStack {

    private final Stack<Integer> data;
    private final Stack<Integer> minValue;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        minValue = new Stack<>();
    }

    public void push(int x) {
        if (minValue.isEmpty() || x < minValue.peek()) {
            minValue.push(x);
        } else {
            minValue.push(minValue.peek());
        }
        data.push(x);
    }

    public void pop() {
        data.pop();
        minValue.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStackTest {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.getMin());
    }
}
