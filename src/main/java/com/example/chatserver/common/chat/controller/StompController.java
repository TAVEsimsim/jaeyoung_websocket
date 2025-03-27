package com.example.chatserver.common.chat.controller;

import com.example.chatserver.common.chat.dto.ChatMessageReqDto;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    private  final SimpMessageSendingOperations messageTemplate;

    public StompController(SimpMessageSendingOperations messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    //    // 방법1.MessageMapping(수신)과 SendTo(topic에 메시지전달) 한꺼번에 처리
//    @MessageMapping("/{roomId}") //클라이언트에서 특정 publish/roomId형태로 메시지를 발행시 MessageMapping 수신
//    @SendTo("/topic/{roomId}")//해당 roomId에 메시지를 반환하여 구독중인 클라이언트에게 메시지전송
//    // DestinationVariable : @MessageMapping 어노테이션으로 정의된 Websocket Contoller 내에서만 사용
//    public String sendMessage(@DestinationVariable Long roomId,String message) {
//
//        System.out.println(message);
//        return message;
//    }
    @MessageMapping("/{roomId}")
    public void sendMessage(@DestinationVariable Long roomId, String message, ChatMessageReqDto chatMessageReqDto) {

        System.out.println(message);
        messageTemplate.convertAndSend("/topic/"+roomId, chatMessageReqDto);

    }

}
