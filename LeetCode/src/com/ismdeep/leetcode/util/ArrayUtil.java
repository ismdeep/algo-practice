package com.ismdeep.leetcode.util;

import com.eclipsesource.json.JsonArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {
    public static String dump(Object[] arr) {
        List<Object> list = new ArrayList<>(Arrays.asList(arr));
        return ListUtil.dump(list);
    }

    public static String dumpInt(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        return dump(tmp);
    }

    public static String dumpInt2d(int[][] nums) {
        if (nums == null) {
            return "null";
        }
        if (nums.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean first = true;
        for (int[] items : nums) {
            if (!first) {
                sb.append(",");
            }
            first = false;
            sb.append(dumpInt(items));
        }
        sb.append("]");

        return sb.toString();
    }

    public static String dumpInt(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static int[] parseIntArr(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] parseInt2dArr(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = parseIntArr(cols.toString());
        }
        return arr;
    }

    public static String[] parseStringArr(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }
}
