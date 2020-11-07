package com.ismdeep.leetcode._204_count_primes;

import org.junit.Test;


class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ++count;
                for (long j = (long) i * (long) i; j < (long) n; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }
        return count;
    }
}

public class CountPrimes {
    @Test
    public void test001() {
        assert new Solution().countPrimes(499979) == 41537;
    }

    @Test
    public void test002() {
        assert new Solution().countPrimes(10) == 4;
    }

    @Test
    public void test003() {
        assert new Solution().countPrimes(7) == 3;
    }
}