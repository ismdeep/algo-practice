package com.ismdeep.leetcode._1108_defanging_an_IP_address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;


class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}

public class DefangingAnIPAddress {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader("1.1.1.1"));
        String line;
        while ((line = in.readLine()) != null) {

            String out = (new Solution().defangIPaddr(line));

            System.out.print(out);
        }
    }
}