package com.axisx.apiuac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Axisx
 */
@Data
public class SysMenu {
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;
    private String name;
    private String permission;
    private String type;
    private String path;
    private Integer pid;
    private String component;
    private String icon;
    private Integer sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private String delFlag;
}
