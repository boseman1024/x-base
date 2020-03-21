package com.axisx.servermessage.controller;

import com.alibaba.fastjson.JSON;
import com.axisx.apimessage.api.MessageApi;
import com.axisx.apimessage.dto.MsgDTO;
import com.axisx.apimessage.enums.MsgStateEnum;
import com.axisx.apimessage.enums.MsgTypeEnum;
import com.axisx.apimessage.vo.MsgVO;
import com.axisx.apiuac.dto.ResponseDTO;
import com.axisx.servermessage.socket.MessageSocket;
import com.axisx.servicemessage.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController implements MessageApi {

    @Autowired
    private MessageSocket messageSocket;
    @Autowired
    private MsgService msgService;

    @Override
    public void sendAll(String message) {
        messageSocket.sendMessageAll(message);
    }

    @Override
    public void sendTo(String to, String message) {
        messageSocket.sendMessageTo(to,message);
    }

    @Override
    public ResponseDTO onlineCount() {
        return ResponseDTO.success(messageSocket.getOnlineCount());
    }

    @Override
    public ResponseDTO save(MsgDTO msgDTO) {
        MsgVO result = msgService.saveMsg(msgDTO);
        if(result!=null){
            if(MsgStateEnum.RELEASE.getValue().equals(msgDTO.getState())&&MsgTypeEnum.ONLINE.getValue().equals(msgDTO.getType())){
                String json = JSON.toJSONString(result);
                messageSocket.sendMessageAll(json);
            }
            return ResponseDTO.success(true);
        }
        return ResponseDTO.success(false);
    }
}
