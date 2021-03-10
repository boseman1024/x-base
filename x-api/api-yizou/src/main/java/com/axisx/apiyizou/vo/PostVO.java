package com.axisx.apiyizou.vo;

import com.axisx.apiuac.vo.UserVO;
import com.axisx.apiyizou.entity.YizouFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVO {
    private Integer id;
    private String location;
    private LocalDateTime createTime;
    private String content;
    private Integer creatorId;
    private UserVO creator;
    private List<YizouFile> files;
}
