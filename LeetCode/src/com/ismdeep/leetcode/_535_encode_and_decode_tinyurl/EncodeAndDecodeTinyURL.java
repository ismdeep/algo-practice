package com.ismdeep.leetcode._535_encode_and_decode_tinyurl;

import org.junit.Test;

public class EncodeAndDecodeTinyURL {

    @Test
    public void test001() {
        Codec codec = new Codec();
        String url = "https://www.baidu.com";
        String url2 = codec.decode(codec.encode(url));
        assert url.equals(url2);
    }
}
