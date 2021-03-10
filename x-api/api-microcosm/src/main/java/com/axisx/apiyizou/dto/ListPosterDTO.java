package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPosterDTO {
    private Integer id;
    private String title;
    private LocalDateTime date;
    private String description;
    private String author;
    private String type;
    private Integer creatorId;
    private Integer pageNo;
    private Integer pageSize;
}
