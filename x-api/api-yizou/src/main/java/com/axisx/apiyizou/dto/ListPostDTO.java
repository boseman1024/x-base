package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPostDTO {
    private Integer id;
    private String location;
    private LocalDateTime createTime;
    private Integer creatorId;
    private Integer fromUserId;
    private Integer pageNo;
    private Integer pageSize;
}
