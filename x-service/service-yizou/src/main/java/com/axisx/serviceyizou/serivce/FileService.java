package com.axisx.serviceyizou.serivce;

import com.axisx.apiyizou.dto.SaveFileDTO;
import com.axisx.apiyizou.entity.YizouFile;

import java.util.List;

public interface FileService {
    List<YizouFile> listByPosterId(Integer posterId);
    Boolean removerByPosterId(Integer posterId);
    Integer save(SaveFileDTO saveFileDTO);
}
