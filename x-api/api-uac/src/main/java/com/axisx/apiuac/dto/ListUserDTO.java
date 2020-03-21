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
public class ListUserDTO {

    private String username;

    private String nickname;

    private String state;

    private Integer pageNo;

    private Integer pageSize;

    private Integer deptId;
}
