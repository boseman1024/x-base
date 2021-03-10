package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCommentDTO {
    private Integer id;
    private Integer pid;
    private Integer postId;
    private Integer fromUserId;
    private Integer toUserId;
    private Integer pageNo;
    private Integer pageSize;
}
