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
public class ListRoleDTO {
    private String name;
    private Integer deptId;
    private Integer pageNo;
    private Integer pageSize;
}
