package com.cc.mybatisdemo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
@ApiModel(value = "ApiResult<T>", description = "接口返回对象")
public class ApiResult<T> {
    private static final String errorMessage = "系统发生异常";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 消息提示
     */
    @ApiModelProperty("消息提示")
    private String message;
    /**
     * 是否成功
     */
    @ApiModelProperty("是否执行成功")
    private boolean succeed;
    /**
     * 状态码
     */
    @ApiModelProperty("状态码")
    private Integer code;
    /**
     * 返回数据
     */
    @ApiModelProperty("返回数据")
    private T data;
    /**
     * 接口返回时间
     */
    @ApiModelProperty("接口返回时间")
    private String responseDate;

    public ApiResult() {}

    public ApiResult success(T data) {
        this.succeed = true;
        this.code = HttpStatus.OK.value();
        this.data = data;
        return this;
    }

    public ApiResult failed() {
        this.succeed = false;
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = ApiResult.errorMessage;
        return this;
    }

    public ApiResult(boolean succeed, String message, Integer code) {
        this.message = message;
        this.succeed = succeed;
        this.code = code;
    }

    public ApiResult(boolean succeed, boolean writeDefault) {
        if (writeDefault) {
            this.code = HttpStatus.OK.value();
            this.succeed = succeed;
            this.message = "";
            this.responseDate = this.dateFormat.format(new Date());
        }
        this.data = null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "message='" + message + '\'' +
                ", succeed=" + succeed +
                ", code=" + code +
                ", data=" + data +
                ", responseDate='" + responseDate + '\'' +
                '}';
    }
}
