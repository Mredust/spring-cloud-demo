package com.mredust.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回结果封装
 *
 * @author <a href="https://github.com/Mredust">Mredust</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 响应码
     */
    private int code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    // 成功构建方法
    public static <T> Result<T> success() {
        return of(HttpStatus.SUCCESS);
    }

    public static <T> Result<T> success(String msg) {
        return of(HttpStatus.SUCCESS, msg);
    }

    public static <T> Result<T> success(T data) {
        return of(HttpStatus.SUCCESS, data);
    }

    public static <T> Result<T> success(HttpStatus HttpStatus) {
        return of(HttpStatus, null);
    }

    public static <T> Result<T> success(HttpStatus HttpStatus, String msg) {
        return of(HttpStatus, msg, null);
    }

    public static <T> Result<T> success(HttpStatus HttpStatus, T data) {
        return of(HttpStatus, data);
    }

    public static <T> Result<T> success(HttpStatus HttpStatus, String msg, T data) {
        return of(HttpStatus, msg, data);
    }

    // 失败构建方法
    public static <T> Result<T> fail() {
        return of(HttpStatus.FAIL);
    }

    public static <T> Result<T> fail(String msg) {
        return of(HttpStatus.FAIL, msg);
    }

    public static <T> Result<T> fail(T data) {
        return of(HttpStatus.FAIL, data);
    }

    public static <T> Result<T> fail(HttpStatus HttpStatus) {
        return of(HttpStatus, null);
    }

    public static <T> Result<T> fail(HttpStatus HttpStatus, String msg) {
        return of(HttpStatus, msg, null);
    }

    public static <T> Result<T> fail(HttpStatus HttpStatus, T data) {
        return of(HttpStatus, data);
    }

    public static <T> Result<T> fail(HttpStatus HttpStatus, String msg, T data) {
        return of(HttpStatus, msg, data);
    }


    // 通用构建方法
    private static <T> Result<T> of(HttpStatus HttpStatus) {
        return of(HttpStatus, null, null);
    }

    private static <T> Result<T> of(HttpStatus HttpStatus, String msg) {
        return of(HttpStatus, msg, null);
    }

    private static <T> Result<T> of(HttpStatus HttpStatus, T data) {
        return of(HttpStatus, null, data);
    }

    private static <T> Result<T> of(HttpStatus HttpStatus, String msg, T data) {
        return new Result<>(
                HttpStatus.getCode(),
                msg != null ? msg : HttpStatus.getMessage(),
                data
        );
    }
}