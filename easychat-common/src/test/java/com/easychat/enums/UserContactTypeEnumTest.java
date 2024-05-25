package com.easychat.enums;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserContactTypeEnumTest {

    @BeforeEach
    void setUp() {
        System.out.println("——————————————————————开始——————————————————————");
    }

    @AfterEach
    void tearDown() {
        System.out.println("——————————————————————结束——————————————————————");
    }

    @Test
    void getByName() {
        UserContactTypeEnum user = UserContactTypeEnum.getByName("USER");
        String desc = user.getDesc();
        assertEquals("好友", desc);
        UserContactTypeEnum group = UserContactTypeEnum.getByName("GROUP");
        String descGroup = group.getDesc();
        assertEquals("群组", descGroup);
    }

    @Test
    void getByProfix() {
    }
}