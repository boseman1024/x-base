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
public class DictVO {
    private Integer id;
    private String code;
    private String label;
    private String value;
    private String type;
    private String description;
    private Integer pid;
    private Integer sort;
}
