package com.example.chatting.repository;

import com.example.chatting.dto.ChatRoom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

//���� DB �� ���� �� Service �� Repository �� �и� ����
@Repository
@Slf4j
public class ChatRepository {

    private Map<String, ChatRoom> chatRoomMap;

    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();
    }

    // ��ü ä�ù� ��ȸ
    public List<ChatRoom> findAllRoom(){
        //ä�ù� ���� ������ �ֱ� ������ ��ȯ
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);

        return chatRooms;
    }

    //roomId �������� ä�ù� ã��
    public ChatRoom findRoomById(String roomId){
        return chatRoomMap.get(roomId);
    }

    //roomName �� ä�ù� �����
    public ChatRoom createChatRoom(String roomName){
        ChatRoom chatRoom = new ChatRoom().create(roomName);

        // map �� ä�÷� ���̵�� ������� ä�÷��� ����
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);

        return chatRoom;
    }

    public void plusUserCnt(String roomId){
        ChatRoom room = chatRoomMap.get(roomId);
        room.setUserCount(room.getUserCount()+1);
    }
    public void minusUserCnt(String roomId){
        ChatRoom room = chatRoomMap.get(roomId);
        room.setUserCount(room.getUserCount()-1);
    }

    // ä�ù� ���� ����Ʈ�� ���� �߰�
    public String addUser(String roomId, String userName){
        ChatRoom room = chatRoomMap.get(roomId);
        String userUUID = UUID.randomUUID().toString();

        // ���̵� �ߺ� Ȯ�� �� userList �� �߰�
        room.getUserList().put(userUUID, userName);

        return userUUID;
    }

    // ä�ù� ���� �̸� �ߺ� Ȯ��
    public String isDuplicateName(String roomId, String userName){
        ChatRoom room = chatRoomMap.get(roomId);
        String tmp = userName;

//        ���� userName �� �ߺ��̶�� ������ ���ڸ� ����
//        �� �� ������ ���ڸ� �ٿ��� �� getUserList �ȿ� �ִ� �г����̶�� �ٽ� ������ ���� ���̱�
//        �ߺ� �г����� ���� ��� > �ڿ��ҼӰ�1, �ڿ��ҼӰ�2, �ڿ��ҼӰ�3 ....
        while (room.getUserList().containsValue(tmp)){
            int ranNum = (int) (Math.random()*100)+1;

            tmp = userName+ranNum;
        }

        return tmp;
    }

    public void delUser(String roomId, String userUUID){
        ChatRoom room = chatRoomMap.get(roomId);
        room.getUserList().remove(userUUID);
    }

    public String getUserName(String roomId, String userUUID){
        ChatRoom room = chatRoomMap.get(roomId);
        return room.getUserList().get(userUUID);
    }

    //ä�ù� ��ü userList ��ȸ
    public ArrayList<String> getUserList(String roomId){
        ArrayList<String> list = new ArrayList<>();

        ChatRoom room = chatRoomMap.get(roomId);

//      hashmap �� for ���� ���� ��
//      value ���� �̾Ƴ��� list �� ���� �� return
        room.getUserList().forEach((key, value) -> list.add(value));
        return list;
    }

}
