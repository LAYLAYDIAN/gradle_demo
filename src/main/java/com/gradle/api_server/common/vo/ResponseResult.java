package com.gradle.api_server.common.vo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * HTTP 响应json值的标准bean
 * Created by DIAN on 2018/11/23 0023.
 */
public class ResponseResult<T> implements Serializable {


    private static final long serialVersionUID = -5675781424666765046L;
    private String errMsg;
    private Integer errCode;
    private Boolean success;
    private T data;

    public ResponseResult() {
        this.errCode = 0;
        this.errMsg = "操作成功";
        this.success =true;
    }

    public ResponseResult(Integer errCode, String errMsg, T data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
