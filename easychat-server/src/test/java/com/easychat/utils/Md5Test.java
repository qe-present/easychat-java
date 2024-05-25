package com.easychat.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Md5Test {

    @Test
    void md5() {
        String str = "123456";
        String md5 = Md5.md5(str);
        assertEquals("e10adc3949ba59abbe56e057f20f883e", md5);
    }
}