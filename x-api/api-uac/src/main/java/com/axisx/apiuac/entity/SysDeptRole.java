package com.axisx.apiuac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Axisx
 */
@Data
public class SysDeptRole {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer deptId;

    private Integer roleId;

    public SysDeptRole(Integer deptId,Integer roleId){
        this.deptId = deptId;
        this.roleId = roleId;
    }
}
