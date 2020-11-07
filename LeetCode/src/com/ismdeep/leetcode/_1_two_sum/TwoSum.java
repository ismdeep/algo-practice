package com.ismdeep.leetcode._1_two_sum;

import org.junit.Test;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = hashMap.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            hashMap.put(nums[i], i);
        }

        return result;
    }
}

public class TwoSum {

    @Test
    public void testTwoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ret = new Solution().twoSum(nums, target);

        assert nums[ret[0]] + nums[ret[1]] == target;

    }

}
