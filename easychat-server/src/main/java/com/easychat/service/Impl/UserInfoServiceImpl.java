package com.easychat.service.Impl;


import com.easychat.entity.UserInfoEntity;
import org.springframework.stereotype.Service;
import com.easychat.service.IUserInfoService;
import com.easychat.mapper.UserInfoMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 用户信息表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity> implements IUserInfoService {

}