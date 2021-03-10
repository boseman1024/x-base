package com.axisx.apiyizou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListLocationDTO {
    private Integer id;
    private Integer postId;
    private Integer userId;
    private LocalDateTime stm;
    private LocalDateTime etm;
    private String name;
    private String address;
    private String pcode;
    private String citycode;
    private String adcode;
}
