package com.ismdeep.leetcode._1534_count_good_triplets;

import org.junit.Test;

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (
                            Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c
                    ) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

public class CountGoodTriplets {

    @Test
    public void test001() {
        assert new Solution().countGoodTriplets(new int[]{3,0,1,1,9,7}, 7, 2, 3) == 4;
    }

}
