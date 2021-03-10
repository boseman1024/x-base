package com.axisx.apiyizou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class YizouLocation {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String postId;
    private String name;
    private Double lat;
    private Double lng;
    private String address;
    private String pcode;
    private String citycode;
    private String adcode;
    private String postcode;
    private String pname;
    private String cityname;
    private String adname;
    private LocalDateTime createTime;
}
