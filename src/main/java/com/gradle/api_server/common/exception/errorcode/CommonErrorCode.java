package com.gradle.api_server.common.exception.errorcode;

/**
 * Created by Administrator on 2018/11/23 0023.
 */
public enum CommonErrorCode implements IErrorCode{
    SUCCESS(200,"请求成功"),
    NOT_FOUND(404,"访问地址无效"),
    FAIL(500,"请求服务失败");
    private int code;
    private String errName;
    private CommonErrorCode(int code, String errName){
        this.code = code;
        this.errName = errName;
    }
    @Override
    public String errName() {
        return errName;
    }

    @Override
    public int errCode() {
        return code;
    }

}
