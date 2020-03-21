package com.axisx.apiuac.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author Axisx
 */
@Getter
public enum MenuTypeEnum {
    /**
     * 1：菜单；2：功能项
     */
    MENU("1"),
    FUNC("2");
    @EnumValue
    private String value;

    MenuTypeEnum(String value) {
        this.value = value;
    }
}
