package com.axisx.servicemessage.service;

import com.axisx.apimessage.dto.MsgDTO;
import com.axisx.apimessage.vo.MsgVO;

public interface MsgService {
    MsgVO saveMsg(MsgDTO msgDTO);
}
