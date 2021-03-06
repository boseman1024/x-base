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
public class UpdateDeptDTO {
    private Integer deptId;
    private String name;
    private String type;
    private Integer pid;
    private Integer sort;
    private String menus;
}
