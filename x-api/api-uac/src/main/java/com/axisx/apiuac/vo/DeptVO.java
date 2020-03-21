package com.axisx.apiuac.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Axisx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptVO {
    private Integer deptId;
    private String name;
    private String type;
    private Integer pid;
    private Integer sort;
    private Integer[] roles;
    private Integer[] menus;
    private Integer[] allMenus;
}
