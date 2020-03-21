package com.axisx.apiuac.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * @author Axisx
 */
@Getter
public enum StateEnum {
    /**
     * 0：正常；1：锁定
     */
    ONE(0, "正常"),
    TWO(1, "锁定");
    @EnumValue
    private int value;
    private String desc;

    StateEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
