package com.easychat.enums;


public enum UserContactTypeEnum {
    USER(0, "U", "好友"),
    GROUP(1,"G","群组");

    private Integer type;
    private String prefix;
    private String desc;

    UserContactTypeEnum(Integer type, String prefix, String desc) {
        this.type = type;
        this.prefix = prefix;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }


    public String getPrefix() {
        return prefix;
    }



    public String getDesc() {
        return desc;
    }


    public static UserContactTypeEnum getByName(String name) {
        try {
            if (name == null || name.isEmpty()) {
                return null;
            }
            return UserContactTypeEnum.valueOf(name.toUpperCase());
        } catch (Exception e) {
            return null;
        }

    }

    public static UserContactTypeEnum getByProfix(String Profix) {
        try {
            if (Profix == null || Profix.isEmpty()) {
                return null;
            }
            Profix = Profix.toUpperCase();
            for (UserContactTypeEnum value : UserContactTypeEnum.values()) {
                if (value.getPrefix().equals(Profix)) {
                    return value;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }

    }
}
