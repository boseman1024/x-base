package com.axisx.apimessage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Axisx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgDTO {
    private Integer id;

    private String title;

    private String content;

    private String sender;

    private String type;

    private String receiver;

    private String state;
}
