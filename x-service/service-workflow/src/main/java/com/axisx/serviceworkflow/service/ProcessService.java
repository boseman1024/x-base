package com.axisx.serviceworkflow.service;

import com.axisx.apiworkflow.dto.ListProcessDTO;
import com.axisx.apiworkflow.vo.ProcessVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface ProcessService {

    IPage<ProcessVO> list(ListProcessDTO listProcessDTO);
}
