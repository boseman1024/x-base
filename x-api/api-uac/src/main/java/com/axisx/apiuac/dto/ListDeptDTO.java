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
public class ListDeptDTO {
    private String name;
    private String type;
    private Integer pid;
    private Integer pageNo;
    private Integer pageSize;
}
