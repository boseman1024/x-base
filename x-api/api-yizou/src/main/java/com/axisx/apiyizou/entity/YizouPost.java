package com.axisx.apiyizou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class YizouPost {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String location;
    private LocalDateTime createTime;
    private String content;
    private Integer creatorId;
    @TableLogic
    private String delFlag;
}
