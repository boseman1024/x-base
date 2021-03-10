package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePosterDTO {
    private String title;
    private LocalDateTime date;
    private String description;
    private String author;
    private String type;
    private Integer sort;
    private List<MediaDTO> medias;
    private Integer creatorId;
}
