package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommentDTO {
    private Integer pid;
    private Integer postId;
    private Integer fromUserId;
    private Integer toUserId;
    private String content;
    private LocalDateTime createTime;
}
