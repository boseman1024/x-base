package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveFileDTO {
    private Character type;
    private String name;
    private String url;
    private LocalDateTime createTime;
    private Integer creatorId;
}
