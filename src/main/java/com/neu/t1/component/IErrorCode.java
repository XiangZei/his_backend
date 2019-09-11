package com.neu.t1.component;
/**
 * 将返回码(ResultCode)中的方法进行封装
 *
 */
public interface IErrorCode {
    long getCode();
    String getMessage();
}
