package com.easychat.controller;

import com.easychat.dto.LoginDto;
import com.easychat.dto.RegisterDto;
import com.easychat.entity.UserInfoEntity;
import com.easychat.result.Result;
import com.mybatisflex.core.paginate.Page;
import io.springboot.captcha.ArithmeticCaptcha;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.easychat.service.IUserInfoService;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.easychat.common.ControllerConstant.CHECKCODEKEY;
import static com.easychat.common.ControllerConstant.CHECKKEY;
import static com.easychat.common.MessageConstant.REDIS_CODE_KEY;
import static com.easychat.common.MessageConstant.REDIS_ONE_MINUTE;

/**
 * 用户信息表 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequestMapping("/account")
@Tag(name = "用户信息相关接口", description = "用户信息相关接口")
@Slf4j
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @GetMapping("/checkCode")
    @Operation(summary = "校验验证码")
    public Result checkCode() {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(100, 42);

        String code = captcha.text();
        String checkCodeKey = UUID.randomUUID().toString();

        String checkCodeBase64 = captcha.toBase64();
        HashMap<String, String> map = new HashMap<>();

        redisTemplate.opsForValue().set(REDIS_CODE_KEY+checkCodeKey, code, REDIS_ONE_MINUTE * 2, TimeUnit.SECONDS);
        map.put(CHECKKEY, checkCodeBase64);
        map.put(CHECKCODEKEY, checkCodeKey);
        return Result.success(map);
    }

    @PostMapping("/login")
    @Operation(summary = "注册")
    public Result register(
            @RequestBody RegisterDto loginDto
    ) {
        String checkCodeKey = loginDto.getCheckCodeKey();
        String redisCodeKey = (String) redisTemplate.opsForValue().get(REDIS_CODE_KEY+checkCodeKey);
        Result result = userInfoService.register(loginDto,redisCodeKey);
        return result;
    }
    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result login(
            @RequestBody LoginDto loginDto
    ) {
        Result result = userInfoService.login(loginDto);
        return result;
    }

    /**
     * 添加 用户信息表
     *
     * @param userInfo 用户信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    public boolean save(@RequestBody UserInfoEntity userInfo) {
        return userInfoService.save(userInfo);
    }


    /**
     * 根据主键删除用户信息表
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return userInfoService.removeById(id);
    }


    /**
     * 根据主键更新用户信息表
     *
     * @param userInfo 用户信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    public boolean update(@RequestBody UserInfoEntity userInfo) {
        return userInfoService.updateById(userInfo);
    }


    /**
     * 查询所有用户信息表
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    public List<UserInfoEntity> list() {
        return userInfoService.list();
    }


    /**
     * 根据用户信息表主键获取详细信息。
     *
     * @param id userInfo主键
     * @return 用户信息表详情
     */
    @GetMapping("/getInfo/{id}")
    public UserInfoEntity getInfo(@PathVariable Serializable id) {
        return userInfoService.getById(id);
    }


    /**
     * 分页查询用户信息表
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page<UserInfoEntity> page(Page<UserInfoEntity> page) {
        return userInfoService.page(page);
    }
}