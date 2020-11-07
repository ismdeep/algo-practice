package com.ismdeep.leetcode._1512_number_of_good_pairs;

import com.ismdeep.leetcode.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 0);
            }
            countMap.put(num, countMap.get(num) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int cnt = entry.getValue();
            if (cnt >= 2) {
                count += cnt * (cnt - 1) / 2;
            }
        }
        return count;
    }
}

public class NumberOfGoodPairs {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new StringReader("[1,2,3,1,1,3]"));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ArrayUtil.parseIntArr(line);

            int ret = new Solution().numIdenticalPairs(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}