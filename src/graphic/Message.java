package graphic;

import Xinxi.src.User;

import java.awt.*;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;

/*
   通用消息类
 */

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    //消息发送者
    private User sendUser ;
    private String receiveUserName;
    public Point point = null;

    //发送时间
    private LocalDateTime time ;
    //消息内容
    private byte[] content ;


    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
    private String username;


    private Message(){}
    public Message(String username){
        this.time = LocalDateTime.now();
        User u = new User() ;
        u.setUsername(username);
        this.sendUser = u ;
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    @Override
    public String toString() {
        return "Message{" +
                "sendUser=" + sendUser +
                ", time=" + time +
                ", content=" + Arrays.toString(content) +
                '}';
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }
}
