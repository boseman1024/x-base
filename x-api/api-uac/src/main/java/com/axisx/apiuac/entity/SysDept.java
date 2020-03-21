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
public class SysDept {
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;
    private String name;
    private String type;
    private Integer pid;
    private Integer sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private String delFlag;
}
