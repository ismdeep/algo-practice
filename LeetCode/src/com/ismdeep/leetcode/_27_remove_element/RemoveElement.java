package com.ismdeep.leetcode._27_remove_element;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;


class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}

public class RemoveElement {

    @Test
    public void test001() {
        int[] nums = new int[]{1,2,2,3};
        int ret = new Solution().removeElement(nums, 2);
        System.out.println(ArrayUtil.dumpInt(nums, ret));
    }
}