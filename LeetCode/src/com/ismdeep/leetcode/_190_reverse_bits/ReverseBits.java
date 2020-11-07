package com.ismdeep.leetcode._190_reverse_bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseBits {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().reverseBits(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
