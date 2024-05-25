package com.easychat.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.lang.String;
import java.lang.Integer;

/**
 * 靓号表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "user_info_beauty")
public class UserInfoBeautyEntity {

    /**
     * 自增id
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 用户id
     */
    @Column(value = "user_id")
    private Integer userId;

    /**
     * 邮箱
     */
    @Column(value = "email")
    private String email;

    /**
     * 状态 0 未使用 1 已使用
     */
    @Column(value = "status")
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
