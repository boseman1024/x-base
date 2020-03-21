package com.axisx.apimessage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgVO {
    private Integer id;

    private String title;

    private String content;

    private String sender;

    private String senderName;

    private String type;

    private String receiver;

    private String state;

    private LocalDateTime updateTime;
}
