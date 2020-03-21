package com.axisx.apiuac.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Axisx
 */
@Data
public class MenuCheckItemVO {
    private Integer menuId;
    private String name;
    private String permission;
    private String type;
    private Integer pid;
    private List<MenuCheckItemVO> function;
}
