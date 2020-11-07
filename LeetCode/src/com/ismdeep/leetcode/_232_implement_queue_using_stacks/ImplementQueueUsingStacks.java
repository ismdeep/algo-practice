package com.ismdeep.leetcode._232_implement_queue_using_stacks;

import java.util.Stack;

class MyQueue {

    private final Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int val = tmp.pop();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return val;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int val = tmp.peek();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return val;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param1 = obj.pop();
        System.out.println(param1);
    }
}
