package com.easychat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者:疏狂难除
 * 时间:2024-05-21
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "hello";
    }
}
