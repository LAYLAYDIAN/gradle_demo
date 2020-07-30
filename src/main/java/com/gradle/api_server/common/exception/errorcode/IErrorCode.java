package com.gradle.api_server.common.exception.errorcode;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
/**
 * rrorCode异常接口
 * 对于不同的应用自建IErrorCode的枚举实现
 * Created by Administrator on 2018/11/23 0023.
 */
public interface IErrorCode {
    /**
     * 错误名称(为具体的枚举常量的name())
     *
     * @return
     */
    String errName();

    /**
     * 错误码
     *
     * @return
     */
    int errCode();

}
