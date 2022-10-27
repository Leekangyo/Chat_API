package com.example.chatting.dto;


import lombok.Data;

import java.util.HashMap;
import java.util.UUID;

//Stomp�� ���� pub/sub �� ����ϸ� ������ ������ �˾Ƽ� �ȴ�.
//���� ���� ���� ������ �ϴ� �ڵ带 �ۼ��� �ʿ䵵 ����,
//�޼����� �ٸ� ������ Ŭ���̾�Ʈ���� �߼��ϴ� �͵� ���� �ʿ䰡 ����.


@Data
public class ChatRoom {

    private String roomId;
    private String roomName;
    private long userCount;

    private HashMap<String, String> userList = new HashMap<String, String>();

    public ChatRoom create(String roomName){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName = roomName;

        return chatRoom;
    }
}
