package com.easychat.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 作者:疏狂难除
 * 时间:2024-05-22
 */
@Data
@Schema(description = "后端统一返回结果")
public class Result<T> implements Serializable{
    @Schema(description = "编码：1成功，0和其它数字为失败")
    public Integer code;
    @Schema(description = "错误信息")
    public String message;
    @Schema(description = "数据")
    public T data;
    public static  Result success(){
        Result result = new Result();
        result.code = 1;
        return result;
    }
    public static  Result success(Object object){
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.message = "操作成功";
        return result;
    }
    public static  Result error(String msg){
        Result result = new Result();
        result.message = msg;
        result.code = 0;
        return result;
    }
}
