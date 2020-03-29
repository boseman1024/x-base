package com.axisx.apifile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author axisx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private String group;
    private String path;
    private String fullPath;
}
