package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveFollowDTO {
    private Integer fromUserId;
    private Integer toUserId;
}
