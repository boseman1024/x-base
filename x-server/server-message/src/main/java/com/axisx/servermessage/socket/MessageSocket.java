package com.axisx.servermessage.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/socket/{username}")
@Slf4j
public class MessageSocket {
    private static int onlineCount = 0;
    private static Map<String, MessageSocket> clients = new ConcurrentHashMap<>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) throws IOException {
        this.username = username;
        this.session = session;
        if(clients.get(username)==null){
            addOnlineCount();
            clients.put(username, this);
            log.info("已连接："+username);
        }
    }

    @OnClose
    public void onClose() throws IOException {
        log.info("断开连接："+username);
        clients.remove(username);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message) throws IOException {

    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MessageSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MessageSocket.onlineCount--;
    }

    public static synchronized Map<String, MessageSocket> getClients() {
        return clients;
    }

    public void sendMessageAll(String message){
        try{
            for (MessageSocket item : clients.values()) {
                item.session.getAsyncRemote().sendText(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessageTo(String to,String message){
        try{
            MessageSocket receiver = clients.get(to);
            if(receiver!=null){
                receiver.session.getAsyncRemote().sendText(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
