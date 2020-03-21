package com.axisx.apimessage.api;

import com.axisx.apimessage.dto.MsgDTO;
import com.axisx.apiuac.dto.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/message")
public interface MessageApi {
    /**
     * 推送消息至当前所有用户
     */
    @PostMapping("/sendAll")
    void sendAll(String message);

    /**
     * 推送消息至某所有用户
     */
    @PostMapping("/sendTo")
    void sendTo(String to,String message);

    /**
     * 当前在线人数
     */
    @GetMapping("/online")
    ResponseDTO onlineCount();

    /**
     * 发送消息
     */
    @PostMapping("/save")
    ResponseDTO save(@RequestBody MsgDTO msgDTO);
}
