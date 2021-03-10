package com.axisx.apimessage.api;

import com.axisx.apimessage.dto.MsgDTO;
import com.axisx.apicommon.dto.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/message")
public interface MessageApi {
    /**
     * 推送消息至当前所有在线用户
     */
    @PostMapping("/sendAllOnline")
    void sendAllOnline(@RequestBody MsgDTO msgDTO);

    /**
     * 推送消息至所有用户
     */
    @PostMapping("/sendAll")
    void sendAll(@RequestBody MsgDTO msgDTO);

    /**
     * 推送消息至某所有用户
     */
    @PostMapping("/sendTo")
    void sendTo(@RequestBody MsgDTO msgDTO);

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
