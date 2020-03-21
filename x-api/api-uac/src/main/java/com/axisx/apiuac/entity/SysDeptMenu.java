package com.axisx.apiuac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Axisx
 */
@Data
public class SysDeptMenu {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer deptId;

    private Integer menuId;

    public SysDeptMenu(Integer deptId,Integer menuId){
        this.deptId = deptId;
        this.menuId = menuId;
    }
}
