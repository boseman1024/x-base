package com.axisx.apiyizou.vo;

import com.axisx.apiuac.vo.UserVO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentVO {
    private Integer id;
    private Integer pid;
    private Integer postId;
    private Integer fromUserId;
    private Integer toUserId;
    private String content;
    private LocalDateTime createTime;
    private UserVO fromUser;
    private UserVO toUser;
}
