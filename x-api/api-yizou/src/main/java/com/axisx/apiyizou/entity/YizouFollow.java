package com.axisx.apiyizou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class YizouFollow {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer fromUserId;
    private Integer toUserId;
}
