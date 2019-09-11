package com.neu.t1.component;
/**
 * 自定义返回的结果
 * CommonResult由三部分构成：
 *     状态码 --前端根据返回的状态码来进行用户权限管理和鉴别后端处理状态
 *              200：操作成功
 *              500：操作失败
 *              404：参数检验失败
 *              401：暂未登陆或者token已经过期
 *              403：没有相关权限
 *      消息提示 --后端返回消息提示，根据状态码返回制定的消息提示，也可以自定义其他具体的消息提示
 *      数据  --后端要返回给前端的数据如果不返回数据可直接传入NULL
 *
 */

import lombok.Data;

@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult(){}

    protected CommonResult(long code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message){
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }
    /**
     * 未登录返回结果
     */
    public static<T> CommonResult<T> unauthorized(T data){
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
    }
    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }


}
