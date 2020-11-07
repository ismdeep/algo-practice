package com.ismdeep.leetcode._442_find_all_duplicates_in_an_array;

import com.ismdeep.leetcode.util.ArrayUtil;
import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                results.add(Math.abs(nums[i]));
            }

            nums[index] = -nums[index];

        }
        return results;
    }
}

public class FindAllDuplicatesInAnArray {

    @Test
    public void test001() {
        List<Integer> results = new Solution().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(ListUtil.dump(results));
    }

}
