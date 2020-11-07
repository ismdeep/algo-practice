package com.ismdeep.leetcode._922_sort_array_by_parity_ii;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int item : A) {
            if (item % 2 == 0) {
                even.add(item);
            } else {
                odd.add(item);
            }
        }
        for (int i = 0; i < A.length / 2; i++) {
            A[i * 2] = even.get(i);
            A[i * 2 + 1] = odd.get(i);
        }
        return A;
    }
}

public class SortArrayByParityII {

    @Test
    public void test001() {
        assert ArrayUtil.dumpInt(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7})).equals("[4,5,2,7]");
    }

    @Test
    public void test002() {
        assert ArrayUtil.dumpInt(new Solution().sortArrayByParityII(new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3})).equals("[2,3,4,1,0,1,0,3,4,3]");
    }
}