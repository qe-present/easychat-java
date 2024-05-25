package com.easychat.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class tokenUserInfoDto implements Serializable {
    private String token;
    private String userId;
    private String nickname;
    private Boolean admin;
}
