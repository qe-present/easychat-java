package com.easychat.service.Impl;


import cn.hutool.core.util.RandomUtil;
import com.easychat.dto.LoginDto;
import com.easychat.dto.RegisterDto;
import com.easychat.entity.UserInfoBeautyEntity;
import com.easychat.entity.UserInfoEntity;
import com.easychat.enums.BeautyAccountStatusEnum;
import com.easychat.enums.UserContactTypeEnum;
import com.easychat.enums.UserStatusEnum;
import com.easychat.mapper.UserInfoBeautyMapper;
import com.easychat.result.Result;
import com.easychat.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easychat.service.IUserInfoService;
import com.easychat.mapper.UserInfoMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

import java.util.Date;
import java.util.Map;

import static com.easychat.common.MessageConstant.*;

/**
 * 用户信息表 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoBeautyMapper userInfoBeautyMapper;


    @Override
    public Result register(RegisterDto loginDto, String redisCodeKey) {
        String code = loginDto.getCode();
        String username = loginDto.getNickname();
        String password = loginDto.getPassword();
        String email = loginDto.getEmail();
//        if (redisCodeKey != code) {
//            return Result.error("验证码错误");
//        }
        Map<String, Object> map = Map.of(
                "email", email
                );
        UserInfoEntity userInfoEntity = userInfoMapper.selectOneByMap(map);
        if (userInfoEntity != null) {
            return Result.error(EMAIL_REGISTERD);
        }
        String userId= UserContactTypeEnum.USER.getPrefix()+RandomUtil.randomNumbers(11);
        UserInfoBeautyEntity userInfoBeautyEntity = userInfoBeautyMapper.selectOneByMap(map);
        boolean useBeautyAccount= null!= userInfoBeautyEntity && BeautyAccountStatusEnum.NO_USE.getStatus().equals(userInfoBeautyEntity.getStatus());
        if (useBeautyAccount) {
            userId=UserContactTypeEnum.USER.getPrefix()+userInfoBeautyEntity.getUserId();
        }
        Date date = new Date();
        UserInfoEntity entity = new UserInfoEntity();
//        entity.setUserId(userId);
        entity.setNickname(username);
        entity.setPassword(Md5.md5(password));
        entity.setEmail(email);
        entity.setCreateTime(date);
        entity.setLastOffTime(date.getTime());
        entity.setStatus(UserStatusEnum.ENABLE.getStatus());
//        userInfoMapper.insert(entity);
//        if (useBeautyAccount) {
//            userInfoBeautyEntity.setStatus(BeautyAccountStatusEnum.USED.getStatus());
//            userInfoBeautyMapper.update(userInfoBeautyEntity);
//        }
        //TODO 创建机器人好友
        return Result.success(REGISTER_SUCCESS);
    }

    @Override
    public Result login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();

        Map<String, Object> map = Map.of(
                "email", email
        );
        UserInfoEntity userInfoEntity = userInfoMapper.selectOneByMap(map);
        if (userInfoEntity == null) {
            return Result.error(USER_NOT_EXIST);
        }
        if (!userInfoEntity.getPassword().equals(Md5.md5(password))) {
            return Result.error(PASSWORD_ERROR);
        }
        return Result.success();


    }

}