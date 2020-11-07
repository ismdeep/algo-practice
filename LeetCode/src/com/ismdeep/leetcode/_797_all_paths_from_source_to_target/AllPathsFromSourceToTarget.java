package com.ismdeep.leetcode._797_all_paths_from_source_to_target;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {

    public static void dfs(List<List<Integer>> results, List<Integer> items, int[][] graph, boolean[] visited, int current) {
        int n = graph.length;
        if (current == n - 1) {
            List<Integer> result = new ArrayList<>(items);
            results.add(result);
            return;
        }

        for (int node : graph[current]) {
            if (!visited[node]) {
                items.add(node);
                visited[node] = true;
                dfs(results, items, graph, visited, node);
                visited[node] = false;
                items.remove(items.size() - 1);
            }
        }

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> items = new ArrayList<>();
        items.add(0);

        dfs(results, items, graph, visited, 0);

        return results;
    }
}

public class AllPathsFromSourceToTarget {

    @Test
    public void test001() {
        List<List<Integer>> results = new Solution().allPathsSourceTarget(new int[][]{
                {1, 2}, {3}, {3}, {}
        });
        System.out.println(ListUtil.dump(results));
    }
}
