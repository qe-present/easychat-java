package com.easychat.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeautyAccountStatusEnumTest {

    @Test
    void getByStatus() {
        BeautyAccountStatusEnum noUse = BeautyAccountStatusEnum.getByStatus(0);
        String desc = noUse.getDesc();
        assertEquals("未使用", desc);
        BeautyAccountStatusEnum used = BeautyAccountStatusEnum.getByStatus(1);
        String descUsed = used.getDesc();
        assertEquals("已使用", descUsed);
    }
}