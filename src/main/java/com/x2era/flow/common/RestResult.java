package com.x2era.flow.common;

import java.util.List;

/**
 * Created on 2019/9/11 1:52 PM
 * 统一封装RestResult对象
 * 统一REST接口返回的数据格式为：{message："",data:{},success:true,totalCount:10,code:200}
 * @author shuke
 * @version 0.1
 **/
public class RestResult<T> {
    /*========常用编码=========*/
    /*** 后段操作成功 ***/
    public  static final  int SUCCESS = 200;
    /** 后端参数校验不通 */
    public static final int INVALID_PARAM = 400;

    /** 后端系统异常 */
    public static final int INNER_ERROR = 500;

    /** 后端操作失败 */
    public static final int FAIL = 501;

    /** session不存在或已失效 */
    public static final int INVALID_SESSION = 561;

    /*============返回数据字段===================*/
    private int code;
    private boolean success;
    private String message;
    private T data;
    /** 分页时才设置该参数 */
    private int totalCount;

    public RestResult() {
    }

    /**
     * 创建RestResult实例（封装success字段赋值的规则）
     *
     * @param code
     * @param message
     * @param data
     * @param totalCount
     * @param <T>
     * @return
     */
    public static <T> RestResult newInstance(int code, String message, T data, int totalCount) {
        RestResult result = new RestResult();
        result.code = code;
        // 仅200时才视为success
        result.success = (code == SUCCESS);
        result.message = message;
        result.data = data;
        result.totalCount = totalCount;
        return result;
    }

    public static <T> RestResult newInstance(int code, String message, T data) {
        return newInstance(code, message, data, 0);
    }

    public static <T> RestResult ok() {
        return newInstance(SUCCESS, "", null);
    }

    public static <T> RestResult ok(T data) {
        return newInstance(SUCCESS, "", data);
    }

    public static <T> RestResult okPage(List<T> data, int totalCount) {
        return newInstance(SUCCESS, "", data, totalCount);
    }

    public static <T> RestResult invalidParams(String message) {
        return newInstance(INVALID_PARAM, message, null);
    }

    public static <T> RestResult fail(T data, String message) {
        return newInstance(FAIL, message, data);
    }

    public static <T> RestResult fail(String message) {
        return newInstance(FAIL, message, null);
    }

    public static <T> RestResult error(String message) {
        return newInstance(INNER_ERROR, message, null);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}