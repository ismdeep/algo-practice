package com.ismdeep.leetcode._49_group_anagrams;

import java.util.*;

class Solution {

    public static String sortChars(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return Arrays.toString(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupMap = new HashMap<>();
        List<String> keys = new ArrayList<>();
        List<List<String>> groups = new ArrayList<>();

        for (String str : strs) {
            String key = sortChars(str);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
                keys.add(key);
            }
            groupMap.get(key).add(str);
        }

        for (String key : keys) {
            groups.add(groupMap.get(key));
        }


        return groups;
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strList = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groups = new Solution().groupAnagrams(strList);
    }
}
