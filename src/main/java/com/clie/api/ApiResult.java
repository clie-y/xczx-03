package com.clie.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： CleanLoamy
 * @date 2022/5/18
 */

public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 8004487252556526569L;
    private Integer status_code;
    private boolean success;
    private String message;
    private T data;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public ApiResult() {
        this.time = new Date();
    }

    public ApiResult(Integer status_code, boolean success, String message, Date time) {
        this.status_code = status_code;
        this.success = success;
        this.message = message;
        this.time = time;
    }

    public ApiResult(Integer status_code, boolean success, String message, T data, Date time) {
        this.status_code = status_code;
        this.success = success;
        this.message = message;
        this.data = data;
        this.time = time;
    }

    /**
     * 具体方法的内部实现
     *
     *
     */
    public static ApiResult<Boolean> result(boolean flag){
        return flag?ok():fail();
    }

    public static <T> ApiResult<T> result(ApiCode apiCode,T data){
        return result(apiCode,null,data);
    }
    public static <T> ApiResult<T> result(ApiCode apiCode,String message,T data){
        boolean success = true;
        return (ApiResult<T>) builder()
                .status_code(apiCode.getCode())
                .success(success).message(message)
                .data(data).time(new Date()).build();
    }


    /**
     * ok()
     * @return
     */
    public static ApiResult<Boolean> ok(){
        return ok(null);
    }

    public static <T>ApiResult<T> ok(ApiCode apiCode){
        return result(apiCode,null);
    }

    public static <T>ApiResult<T> ok(ApiCode apiCode,String message,T data){
        return result(apiCode,message,data);
    }

    /**
     * fail()
     * @return
     */
    public static ApiResult<Boolean> fail(){
        return fail(null);
    }
    public static <T> ApiResult<T> fail(ApiCode apiCode){
        return result(apiCode,null);
    }
    public static <T> ApiResult<T> fail(ApiCode apiCode,T data){
        return result(apiCode,data);
    }
    public static <T> ApiResult<T> fail(ApiCode apiCode,String message,T data){
        return result(apiCode,message,data);
    }

    /**
     * builder()
     */
    public static <T> ApiResult.ApiResultBuilder<T> builder(){
        return new ApiResult.ApiResultBuilder();
    }

    /**
     * 父类的Getter和Setter方法
     */
    public Integer getStatus_code() {
        return status_code;
    }

    public ApiResult<T> setStatus_code(Integer status_code) {
        this.status_code = status_code;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ApiResult<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ApiResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public ApiResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Date getTime() {
        return time;
    }
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    public ApiResult<T> setTime(Date time) {
        this.time = time;
        return this;
    }



    /**
     *
     * 内部类
     *
     * @param <T>
     */
    public static class ApiResultBuilder<T> {
        private Integer status_code;
        private boolean success;
        private String message;
        private T data;
        private Date time;
        ApiResultBuilder(){
        }

        public ApiResultBuilder<T> status_code(final int status_code){
            this.status_code = status_code;
            return this;
        }
        public ApiResultBuilder<T> success(final boolean success){
            this.success = success;
            return this;
        }
        public ApiResultBuilder<T> message(final String message){
            this.message = message;
            return this;
        }
        public ApiResultBuilder<T> data(final T data){
            this.data = data;
            return this;
        }
        @JsonFormat(
                pattern = "yyyy-MM-dd HH:mm:ss",
                timezone = "GMT+8"
        )
        public ApiResultBuilder<T> time(final Date time){
            this.time = time;
            return this;
        }

        public ApiResult<T> build(){
            return new ApiResult(this.status_code, this.success, this.message, this.data, this.time);
        }

    }
}
