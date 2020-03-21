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
public class ListDictDTO {
    private String code;
    private String label;
    private String type;
    private Integer pid;
    private Integer pageNo;
    private Integer pageSize;
}
