package com.axisx.servermessage.controller;

import com.alibaba.fastjson.JSON;
import com.axisx.apimessage.api.MessageApi;
import com.axisx.apimessage.dto.MsgDTO;
import com.axisx.apimessage.enums.MsgStateEnum;
import com.axisx.apimessage.enums.MsgTypeEnum;
import com.axisx.apimessage.vo.MsgVO;
import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.servermessage.socket.MessageSocket;
import com.axisx.servicemessage.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController implements MessageApi {

    @Autowired
    private MessageSocket messageSocket;
    @Autowired
    private MsgService msgService;

    @Override
    public void sendAllOnline(@RequestBody MsgDTO msgDTO) {
        MsgVO result = new MsgVO();
        result.setContent(msgDTO.getContent());
        messageSocket.sendMessageAllOnline(JSON.toJSONString(result));
    }

    @Override
    public void sendAll(@RequestBody MsgDTO msgDTO) {
        MsgVO result = new MsgVO();
        result.setContent(msgDTO.getContent());
        messageSocket.sendAll(JSON.toJSONString(result));
    }

    @Override
    public void sendTo(@RequestBody MsgDTO msgDTO) {
        MsgVO result = new MsgVO();
        result.setContent(msgDTO.getContent());
        messageSocket.sendMessageTo(msgDTO.getReceiver(),JSON.toJSONString(result));
    }

    @Override
    public ResponseDTO onlineCount() {
        return ResponseDTO.success(MessageSocket.getOnlineCount());
    }

    @Override
    public ResponseDTO save(MsgDTO msgDTO) {
        MsgVO result = msgService.saveMsg(msgDTO);
        if(result!=null){
            if(MsgStateEnum.RELEASE.getValue().equals(msgDTO.getState())&&MsgTypeEnum.ONLINE.getValue().equals(msgDTO.getType())){
                String json = JSON.toJSONString(result);
                messageSocket.sendMessageAllOnline(json);
            }
            if(MsgStateEnum.RELEASE.getValue().equals(msgDTO.getState())&&MsgTypeEnum.ALL.getValue().equals(msgDTO.getType())){
                String json = JSON.toJSONString(result);
                messageSocket.sendAll(json);
            }
            if(MsgStateEnum.RELEASE.getValue().equals(msgDTO.getState())&&MsgTypeEnum.TO.getValue().equals(msgDTO.getType())){
                String json = JSON.toJSONString(result);
                messageSocket.sendMessageTo(result.getReceiver(),json);
            }
            return ResponseDTO.success(true);
        }
        return ResponseDTO.success(false);
    }
}
