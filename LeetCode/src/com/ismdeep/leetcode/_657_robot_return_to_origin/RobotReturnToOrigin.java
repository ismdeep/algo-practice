package com.ismdeep.leetcode._657_robot_return_to_origin;

import org.junit.Test;


class Solution {
    public boolean judgeCircle(String moves) {

        int x, y;
        x = 0;
        y = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    x -= 1;
                    break;
                case 'D':
                    x += 1;
                    break;
                case 'L':
                    y -= 1;
                    break;
                case 'R':
                    y += 1;
                    break;
            }
        }

        return x == 0 && y == 0;
    }
}

public class RobotReturnToOrigin {
    @Test
    public void test001() {
        assert new Solution().judgeCircle("UD");
    }

    @Test
    public void test002() {
        assert !new Solution().judgeCircle("LL");
    }
}