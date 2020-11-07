package com.ismdeep.leetcode._841_keys_and_rooms;

import com.eclipsesource.json.JsonArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> nextVisit = new PriorityQueue<>();

        for (int i = 0; i < rooms.size(); i++) {
            visited[i] = false;
        }

        nextVisit.add(0);
        visited[0] = true;

        while (!nextVisit.isEmpty()) {
            int room = nextVisit.poll();
            for (int nextRoom : rooms.get(room)) {
                if (!visited[nextRoom]) {
                    nextVisit.add(nextRoom);
                    visited[nextRoom] = true;
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                return false;
            }
        }


        return true;
    }
}

public class KeysAndRooms {
    private static List<Integer> stringToIntegerList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        List<Integer> arr = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            arr.add(jsonArray.get(i).asInt());
        }
        return arr;
    }

    public static List<List<Integer>> stringToInt2dList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToIntegerList(cols.toString()));
        }
        return list;
    }

    @Test
    public void test001() {
        List<List<Integer>> rooms = stringToInt2dList("[[1],[2],[3],[]]");
        assert new Solution().canVisitAllRooms(rooms);
    }

    @Test
    public void test002() {
        List<List<Integer>> rooms = stringToInt2dList("[[1,3],[3,0,1],[2],[0]]");
        assert !new Solution().canVisitAllRooms(rooms);
    }
}