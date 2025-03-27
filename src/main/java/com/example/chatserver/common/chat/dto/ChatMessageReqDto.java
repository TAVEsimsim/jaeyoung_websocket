package com.example.chatserver.common.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageReqDto {
    private String message;
    private String senderEmail;
}
