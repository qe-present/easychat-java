package com.easychat.utils;
import cn.hutool.crypto.SecureUtil;
public class Md5 {
    public static String md5(String str) {
        return SecureUtil.md5(str);
    }

}
