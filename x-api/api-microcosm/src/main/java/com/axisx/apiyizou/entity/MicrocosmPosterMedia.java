package com.axisx.apiyizou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MicrocosmPosterMedia {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer posterId;
    private String link;
    private String type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private String delFlag;
}
