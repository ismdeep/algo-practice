package com.ismdeep.leetcode._1395_count_number_of_teams;

import org.junit.Test;

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || rating[i] > rating[j] && rating[j] > rating[k]) {
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }
}

public class CountNumberOfTeams {

    @Test
    public void test001() {
        assert new Solution().numTeams(new int[]{2, 5, 3, 4, 1}) == 3;
    }
}
