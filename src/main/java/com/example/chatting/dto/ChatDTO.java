package com.example.chatting.dto;

import com.example.chatting.constant.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {
//    메세지 타입 : 입장, 채팅
//    메세지 타입에 따라서 동작하는 구조가 달라진다.
//    입장과 퇴장 ENTER 와 LEAVE 의 경우 입장 / 퇴장의 이벤트 처리가 실행 되고
//    TALK는 말 그대로 해당 채팅방을 Sub 하고 있는 모든 클라이언트들게 내용을 보내는 것이다.

    private MessageType type; //메세지 타입
    private String roomId;
    private String sender;
    private String message;
    private String time;
}
