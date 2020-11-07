package com.ismdeep.leetcode._18_4sum;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.*;

class Solution {

    public String fourSumToString(int v1, int v2, int v3, int v4) {
        return v1 +
                ";" +
                v2 +
                ";" +
                v3 +
                ";" +
                v4;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);
        Set<String> set = new HashSet<>();

        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    for (int i4 = i3 + 1; i4 < nums.length; i4++) {
                        if (nums[i1] + nums[i2] + nums[i3] + nums[i4] == target) {
                            List<Integer> result = new ArrayList<>();
                            result.add(nums[i1]);
                            result.add(nums[i2]);
                            result.add(nums[i3]);
                            result.add(nums[i4]);
                            String tmpStr = fourSumToString(nums[i1], nums[i2], nums[i3], nums[i4]);
                            if (!set.contains(tmpStr)) {
                                results.add(result);
                                set.add(tmpStr);
                            }

                        }
                    }
                }
            }
        }

        return results;
    }
}

public class SumOfFourNumbers {

    @Test
    public void test001() {
        List<List<Integer>> results = new Solution().fourSum(new int[]{1, 0, 0, -1, 0, -2, 2}, 0);
        System.out.println(ListUtil.dump(results));
    }

}
