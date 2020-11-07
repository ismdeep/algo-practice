package com.ismdeep.leetcode._20_valid_parentheses;

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Set<Character> left = new HashSet<>();
        left.add('[');
        left.add('(');
        left.add('{');

        Map<Character, Character> pair = new HashMap<>();
        pair.put('}', '{');
        pair.put(')', '(');
        pair.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (left.contains(ch)) {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (stack.peek() != pair.get(ch)) {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}

public class ValidParentheses {
    public static void main(String[] args) {
        assert new Solution().isValid("[]");
        assert ! new Solution().isValid("}");
        assert new Solution().isValid("()");
        assert new Solution().isValid("[");
    }
}
