package com.ismdeep.leetcode._231_power_of_two;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


class Solution {

    public static Set<Integer> data;

    static {
        data = new HashSet<>();
        int[] arr = new int[]{
                1, 65536, 2, 131072, 4, 262144, 8, 524288,
                16, 1048576, 32, 2097152,64, 128, 256,512, 1024, 2048, 4096, 8192, 16384, 32768, 4194304, 8388608, 16777216, 33554432,
                67108864, 134217728, 268435456, 536870912, 1073741824};
        for (int item : arr) {
            data.add(item);
        }
    }

    public boolean isPowerOfTwo(int n) {
        return data.contains(n);
    }
}

public class PowerOfTwo {
    @Test
    public void testIsPowerOfTwo() {
        assert new Solution().isPowerOfTwo(1);
        assert new Solution().isPowerOfTwo(1024);
    }

    @Test
    public void testIsNotPowerOfTwo() {
        assert !new Solution().isPowerOfTwo(6);
        assert !new Solution().isPowerOfTwo(3);
    }

}