package com.clie.api;

public enum ApiCode {


    SUCCESS(200,"操作成功"),
    FAIL(500, "操作失败");



    private final Integer code;
    private final String message;

    private ApiCode(final int code,final String message){
        this.code = code;
        this.message = message;
    }

    /**
     * getApiCode()方法不太明白
     * @param code
     * @return
     */
    public static ApiCode getApiCode(Integer code){
        ApiCode[] ecs = values();
        ApiCode[] var2 = ecs;
        int var3 = ecs.length;

        for (int var4 = 0;var4 < var3;++var4){
            ApiCode ec = var2[var4];
            if (ec.getCode()==code){
                return ec;
            }
        }
        return SUCCESS;
    }

    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }
}
