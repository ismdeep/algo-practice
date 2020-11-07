package com.ismdeep.leetcode._88_merge_sorted_array;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = nums1.length - 1;
        int cursor = nums2.length - 1;
        while (cursor >= 0) {
            while (left >= 0 && nums2[cursor] < nums1[left]) {
                nums1[right] = nums1[left];
                right--;
                left--;
            }

            nums1[right] = nums2[cursor];
            right--;
            cursor--;
        }
    }
}

public class MergeSortedArray {
    @Test
    public void test001() {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        new Solution().merge(num1, 3, num2, 3);
        System.out.println(ArrayUtil.dumpInt(num1));
    }
}