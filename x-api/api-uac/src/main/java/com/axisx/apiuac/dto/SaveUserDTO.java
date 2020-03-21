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
public class SaveUserDTO {
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String phone;
    private String roles;
    private Integer deptId;
    private String state;
}
