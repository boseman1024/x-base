package com.axisx.apiuac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Axisx
 */
@Data
public class SysDeptUser {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer deptId;

    private Integer userId;

    public SysDeptUser(Integer deptId, Integer userId) {
        this.deptId = deptId;
        this.userId = userId;
    }
}
