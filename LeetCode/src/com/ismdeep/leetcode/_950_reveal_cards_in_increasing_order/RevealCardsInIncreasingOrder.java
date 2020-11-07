package com.ismdeep.leetcode._950_reveal_cards_in_increasing_order;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sortedIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            sortedIndex.add(queue.poll());
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        Arrays.sort(deck);

        for (int i = 0; i < n; i++) {
            result[sortedIndex.get(i)] = deck[i];
        }

        return result;
    }
}

public class RevealCardsInIncreasingOrder {

    @Test
    public void test001() {
        int[] result = new Solution().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
        System.out.println(ArrayUtil.dumpInt(result));
    }
}
