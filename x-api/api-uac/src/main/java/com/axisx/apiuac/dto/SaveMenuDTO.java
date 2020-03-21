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
public class SaveMenuDTO {
    private String name;
    private String permission;
    private String type;
    private String path;
    private Integer pid;
    private String component;
    private String icon;
    private Integer sort;
}
