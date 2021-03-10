package com.axisx.apimessage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgPartDTO {
    private String to;
    private String message;
}
