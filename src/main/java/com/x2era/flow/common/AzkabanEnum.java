package com.x2era.flow.common;

public enum AzkabanEnum {
    //环境
    ENV_DEV(1, "开发"),

    ENV_PRE(2, "预发"),

    ENV_PROD(3, "生产");

    private Integer type;

    private String msg;

    AzkabanEnum(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public Integer getType(){
        return this.type;
    }
}
