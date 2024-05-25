package com.easychat.enums;

public enum BeautyAccountStatusEnum {
    NO_USE(0, "未使用"),
    USED(1, "已使用");
    private Integer status;
    private String desc;
    BeautyAccountStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
    public Integer getStatus() {
        return status;
    }
    public String getDesc() {
        return desc;
    }
    public static BeautyAccountStatusEnum getByStatus(Integer status) {
        try {
            if (status == null) {
                return null;
            }
            for (BeautyAccountStatusEnum value : BeautyAccountStatusEnum.values()) {
                if (value.getStatus().equals(status)) {
                    return value;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
