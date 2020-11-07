package NC52_ParenthesesSequence;

import java.util.*;


public class Solution {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.isEmpty()) return false;

            char top = stack.pop();

            if (top == '[' && s.charAt(i) == ']') continue;
            if (top == '(' && s.charAt(i) == ')') continue;
            if (top == '{' && s.charAt(i) == '}') continue;

            return false;
        }

        return stack.isEmpty();
    }
}