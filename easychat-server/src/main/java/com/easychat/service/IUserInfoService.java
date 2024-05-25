package com.easychat.service;


import com.easychat.dto.LoginDto;
import com.easychat.dto.RegisterDto;
import com.easychat.entity.UserInfoEntity;
import com.easychat.result.Result;
import com.mybatisflex.core.service.IService;

/**
 * 用户信息表 服务层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
public interface IUserInfoService extends IService<UserInfoEntity> {

    Result register(RegisterDto loginDto, String redisCodeKey);

    Result login(LoginDto loginDto);
}