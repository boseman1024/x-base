package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePostDTO {
    private String location;
    private LocalDateTime createTime;
    private String content;
    private Integer creatorId;
    private List<SaveFileDTO> files;
}
