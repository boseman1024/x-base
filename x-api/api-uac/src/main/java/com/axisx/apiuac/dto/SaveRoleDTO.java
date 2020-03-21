package com.axisx.apiuac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Axisx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveRoleDTO {
    private String name;
    private String code;
    private String description;
    private Integer deptId;
    private String menus;
}
