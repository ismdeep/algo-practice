package com.ismdeep.leetcode.util;

import java.io.*;

public class ReaderUtil {
    public static BufferedReader loadAsBufferedReader(String path) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
    }
}
