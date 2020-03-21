package com.axisx.apimessage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum MsgTypeEnum {
    /**
     * 0：在线用户；1：所有用户；2：指定用户
     */
    ONLINE("0", "在线用户"),
    ALL("1", "所有用户"),
    TO("2", "指定用户");

    @EnumValue
    private String value;
    private String desc;

    MsgTypeEnum(String value,String desc) {
        this.value = value;
        this.desc = desc;
    }
}
