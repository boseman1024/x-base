package com.axisx.apiworkflow.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessVO {
    private String id;
    private String name;
    private String key;
    private String resourceName;
    private String category;
    private Integer suspensionState;
    private Integer startAble;
    private Integer version;
}
