package com.axisx.apimessage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum MsgStateEnum {
    /**
     * 0：草稿；1：发布
     */
    DRAFT("0", "草稿"),
    RELEASE("1", "发布");

    @EnumValue
    private String value;
    private String desc;

    MsgStateEnum(String value,String desc) {
        this.value = value;
        this.desc = desc;
    }
}
