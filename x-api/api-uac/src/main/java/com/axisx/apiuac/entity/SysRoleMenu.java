package com.axisx.apiuac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Axisx
 */
@Data
public class SysRoleMenu {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    public SysRoleMenu(Integer roleId,Integer menuId){
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
