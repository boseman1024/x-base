package com.axisx.serviceworkflow.service.impl;

import com.axisx.apiworkflow.dto.ListProcessDTO;
import com.axisx.apiworkflow.entity.ActReProcdef;
import com.axisx.apiworkflow.vo.ProcessVO;
import com.axisx.serviceworkflow.dao.ActReProcdefMapper;
import com.axisx.serviceworkflow.service.ProcessService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ActReProcdefMapper actReProcdefMapper;

    private BeanCopier beanCopier;

    @Override
    public IPage<ProcessVO> list(ListProcessDTO listProcessDTO) {
        beanCopier = BeanCopier.create(ListProcessDTO.class, ActReProcdef.class,false);
        ActReProcdef actReProcdef = new ActReProcdef();
        beanCopier.copy(listProcessDTO,actReProcdef,null);
        return actReProcdefMapper.listProcess(new Page<>(listProcessDTO.getPageNo(),listProcessDTO.getPageSize()),actReProcdef);
    }
}
