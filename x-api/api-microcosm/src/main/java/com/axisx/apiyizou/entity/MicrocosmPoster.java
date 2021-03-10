package com.axisx.apiyizou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MicrocosmPoster {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private LocalDateTime date;
    private String description;
    private String author;
    private Integer sort;
    private String type;
    private Integer creatorId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private String delFlag;
}
