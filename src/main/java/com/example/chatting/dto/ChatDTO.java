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
//    �޼��� Ÿ�� : ����, ä��
//    �޼��� Ÿ�Կ� ���� �����ϴ� ������ �޶�����.
//    ����� ���� ENTER �� LEAVE �� ��� ���� / ������ �̺�Ʈ ó���� ���� �ǰ�
//    TALK�� �� �״�� �ش� ä�ù��� Sub �ϰ� �ִ� ��� Ŭ���̾�Ʈ��� ������ ������ ���̴�.

    private MessageType type; //�޼��� Ÿ��
    private String roomId;
    private String sender;
    private String message;
    private String time;
}
