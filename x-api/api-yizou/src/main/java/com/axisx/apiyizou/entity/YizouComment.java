package com.axisx.apiyizou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class YizouComment {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private Integer postId;
    private Integer fromUserId;
    private Integer toUserId;
    private String content;
    private LocalDateTime createTime;
    @TableLogic
    private String delFlag;
}
