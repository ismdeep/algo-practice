package com.ismdeep.leetcode._332_reconstruct_itinerary;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static boolean dfs(HashMap<String, List<String>> nextMap, String current, List<String> path, int pathSizeMax) {

        if (path.size() >= pathSizeMax) {
            return true;
        }

        if (!nextMap.containsKey(current)) {
            return false;
        }

        if (nextMap.get(current).size() <= 0) {
            return false;
        }

        String[] nextNodes = new String[nextMap.get(current).size()];
        for (int i = 0; i < nextMap.get(current).size(); i++) {
            nextNodes[i] = nextMap.get(current).get(i);
        }

        Arrays.sort(nextNodes);

        for (String nextNode : nextNodes) {
            path.add(nextNode);
            nextMap.get(current).remove(nextNode);
            if (dfs(nextMap, nextNode, path, pathSizeMax)) {
                return true;
            }
            nextMap.get(current).add(nextNode);
            path.remove(path.size() - 1);
        }

        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> path = new ArrayList<>();

        HashMap<String, List<String>> nextMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!nextMap.containsKey(from)) {
                nextMap.put(from, new ArrayList<>());
            }
            nextMap.get(from).add(to);
        }

        String current = "JFK";
        path.add(current);
        dfs(nextMap, current, path, tickets.size() + 1);

        return path;
    }

}

public class ReconstructItinerary {
    @Test
    public void test001() {
        List<List<String>> tickets = ListUtil.parseTo2DString("[[\"JFK\",\"KUL\"],[\"JFK\",\"NRT\"],[\"NRT\",\"JFK\"]]");
        List<String> ret = new Solution().findItinerary(tickets);
        String out = ListUtil.dump(ret);
        assert out.equals("[\"JFK\",\"NRT\",\"JFK\",\"KUL\"]");
    }
}