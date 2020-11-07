package com.ismdeep.leetcode.util;

import com.eclipsesource.json.JsonArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {

    public static String dump(List<?> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean first = true;
        for (Object item : list) {
            if (!first) {
                sb.append(",");
            }
            first = false;
            if (item.getClass().getTypeName().equals("java.lang.String")) {
                sb.append(String.format("\"%s\"", item));
            } else if (item.getClass().getTypeName().equals("java.util.ArrayList")) {
                sb.append(dump((List<?>) item));
            } else {
                sb.append(item.toString());
            }

        }

        sb.append("]");
        return sb.toString();
    }

    public static List<String> parseToString(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.get(i).asString());
        }
        return list;
    }

    public static List<List<String>> parseTo2DString(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(parseToString(cols.toString()));
        }
        return list;
    }
}
