package com.ismdeep.leetcode._347_top_k_frequent_elements;

import org.junit.Test;

import java.util.*;

class Solution {

    static class Pair {
        public int val;
        public int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (!count.containsKey(num)) {
                count.put(num, 0);
            }
            count.put(num, count.get(num) + 1);
        }

        List<Pair> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }

        list.sort((o1, o2) -> Integer.compare(o2.count, o1.count));

        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = list.get(i).val;
        }
        return results;
    }
}


public class Top_K_FrequentElements {

    @Test
    public void test001() {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] results = new Solution().topKFrequent(nums, k);
        assert results.length == k;
        assert results[0] == 1;
        assert results[1] == 2;
    }

}
