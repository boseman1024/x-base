package com.axisx.apiworkflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProcessDTO {
    private String name;
    private String key;
    private String resourceName;
    private String category;
    private Integer suspensionState;
    private Integer startAble;
    private String group;
    private Integer pageNo;
    private Integer pageSize;
}

