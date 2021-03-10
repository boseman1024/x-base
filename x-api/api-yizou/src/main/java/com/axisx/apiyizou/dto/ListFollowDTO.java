package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFollowDTO {
    private Integer fromUserId;
    private Integer toUserId;
    private Integer pageNo;
    private Integer pageSize;
}
