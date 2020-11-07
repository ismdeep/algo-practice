package com.ismdeep.leetcode._535_encode_and_decode_tinyurl;

import java.util.HashMap;
import java.util.Random;

public class Codec {

    public static String genUri() {
        String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(base.charAt(rand.nextInt(base.length())));
        }
        return sb.toString();
    }

    private final HashMap<String, String> encodeMap = new HashMap<>();
    private final HashMap<String, String> decodeMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodeMap.containsKey(longUrl)) {
            return "http://tinyurl.com/" + encodeMap.containsKey(longUrl);
        }
        String uri = genUri();
        while (decodeMap.containsKey(uri)){
            uri=genUri();
        }
        decodeMap.put(uri, longUrl);
        encodeMap.put(longUrl, uri);
        return "http://tinyurl.com/" + uri;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.substring("http://tinyurl.com/".length());
        return decodeMap.get(shortUrl);
    }
}
