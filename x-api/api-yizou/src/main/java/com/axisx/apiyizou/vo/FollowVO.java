package com.axisx.apiyizou.vo;

import com.axisx.apiuac.vo.UserVO;
import lombok.Data;

@Data
public class FollowVO {
    private Integer fromUserId;
    private Integer toUserId;
    private UserVO user;
}
