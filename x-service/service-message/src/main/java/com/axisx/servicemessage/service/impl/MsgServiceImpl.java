package com.axisx.servicemessage.service.impl;

import com.axisx.apimessage.dto.MsgDTO;
import com.axisx.apimessage.entity.MsgStore;
import com.axisx.apimessage.vo.MsgVO;
import com.axisx.servicemessage.dao.MsgMapper;
import com.axisx.servicemessage.service.MsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, MsgStore> implements MsgService {

    private BeanCopier beanCopier;

    @Override
    public MsgVO saveMsg(MsgDTO msgDTO) {
        beanCopier = BeanCopier.create(MsgDTO.class,MsgStore.class,false);
        MsgStore msgStore = new MsgStore();
        beanCopier.copy(msgDTO,msgStore,null);
        if(this.save(msgStore)){
            beanCopier = BeanCopier.create(MsgStore.class,MsgVO.class,false);
            MsgVO msgVO = new MsgVO();
            beanCopier.copy(msgStore,msgVO,null);
            return msgVO;
        }
        return null;
    }
}
