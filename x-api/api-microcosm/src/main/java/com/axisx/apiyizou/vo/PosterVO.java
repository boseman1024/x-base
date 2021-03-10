package com.axisx.apiyizou.vo;

import com.axisx.apiyizou.entity.MicrocosmPosterMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosterVO {
    private Integer id;
    private String title;
    private String description;
    private String author;
    private String type;
    private String sort;
    private List<MicrocosmPosterMedia> medias;
}
