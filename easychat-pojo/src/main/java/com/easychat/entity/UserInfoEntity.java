package com.easychat.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 用户信息表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "user_info")
public class UserInfoEntity {

    /**
     * 用户id
     */
    @Id(keyType = KeyType.Auto)
    private Integer userId;

    /**
     * 邮箱
     */
    @Column(value = "email")
    private String email;

    /**
     * 密码
     */
    @Column(value = "password")
    private String password;

    /**
     * 昵称
     */
    @Column(value = "nickname")
    private String nickname;

    /**
     * 加入类型 0 直接加入 1 同意后加好友
     */
    @Column(value = "join_type")
    private String joinType;

    /**
     * 性别
     */
    @Column(value = "sex")
    private String sex;

    /**
     * 个性签名
     */
    @Column(value = "personal_signature")
    private String personalSignature;

    /**
     * 状态
     */
    @Column(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(value = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(value = "last_login_time")
    private Date lastLoginTime;

    /**
     * 地区名称
     */
    @Column(value = "area_name")
    private String areaName;

    /**
     * 地区编码
     */
    @Column(value = "area_code")
    private String areaCode;

    /**
     * 最后下线时间
     */
    @Column(value = "last_off_time")
    private Long lastOffTime;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Long getLastOffTime() {
        return lastOffTime;
    }

    public void setLastOffTime(Long lastOffTime) {
        this.lastOffTime = lastOffTime;
    }
}
