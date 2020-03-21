package com.axisx.apimessage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Axisx
 */
@Data
public class MsgStore {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private String sender;

    private String type;

    private String receiver;

    private String state;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @TableLogic
    private String delFlag;
}
