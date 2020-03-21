package com.axisx.apiuac.vo;

import com.axisx.apiuac.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Axisx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Integer userId;

    private String username;

    private String nickname;

    private String phone;

    private String avatar;

    private String state;
}
