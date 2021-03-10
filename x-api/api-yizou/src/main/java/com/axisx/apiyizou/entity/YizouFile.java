package com.axisx.apiyizou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class YizouFile {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Character type;
    private String name;
    private String url;
    private LocalDateTime createTime;
    private Integer creatorId;
    @TableLogic
    private String delFlag;
}
