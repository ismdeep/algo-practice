package com.ismdeep.leetcode._1389_create_target_array_in_the_given_order;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;


class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 2; j >= index[i]; j--) {
                result[j + 1] = result[j];
            }

            result[index[i]] = nums[i];
        }
        return result;
    }
}

public class CreateTargetArrayInTheGivenOrder {
    @Test
    public void test001() {
        assert ArrayUtil.dumpInt(new Solution().createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})).equals("[0,4,1,3,2]");
    }
}
