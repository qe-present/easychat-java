package com.easychat.enums;


public enum UserStatusEnum {
    DISABLE(0, "禁用"),
    ENABLE(1, "启用");
    private Integer status;
    private String desc;
    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
    public Integer getStatus() {
        return status;
    }
    public String getDesc() {
        return desc;
    }
    public static UserStatusEnum getByStatus(Integer status) {
        try {
            if (status == null) {
                return null;
            }
            for (UserStatusEnum value : UserStatusEnum.values()) {
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
