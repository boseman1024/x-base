package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePostFileDTO {
    private Integer postId;
    private Integer fileId;
}
