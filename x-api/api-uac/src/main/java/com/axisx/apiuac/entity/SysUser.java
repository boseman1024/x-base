package com.axisx.apiuac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Axisx
 */
@Data
public class SysUser {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String password;

    private String nickname;

    private String salt;

    private String phone;

    private String avatar;

    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;

    private String state;

    @TableLogic
    private String delFlag;

}
