package com.axisx.apiyizou.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum MediaType {
    /**
     * 1：背景图片；2：封面；3：音频；4：视频
     */
    BACKGROUND("1"),
    COVER("2"),
    MUSIC("3"),
    VIDEO("4");

    @EnumValue
    private String value;

    MediaType(String value) {
        this.value = value;
    }
}
