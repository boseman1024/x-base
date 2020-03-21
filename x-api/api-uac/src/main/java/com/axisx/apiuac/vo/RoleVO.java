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
public class RoleVO {
    private Integer roleId;
    private String name;
    private String code;
    private String description;
    private Integer[] menus;
}
