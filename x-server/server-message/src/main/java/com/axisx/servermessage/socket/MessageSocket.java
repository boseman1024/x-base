package com.axisx.servermessage.socket;

import ch.qos.logback.core.util.TimeUtil;
import com.axisx.apimessage.dto.MsgPartDTO;
import com.axisx.xutil.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@ServerEndpoint("/socket/{id}")
@Slf4j
public class MessageSocket {
    public static final int CORE_POOL_SIZE = 1;
    public static final int MAXIMUM_POOL_SIZE = 3;
    public static final int KEEP_ALIVE_TIME = 10;
    public static final TimeUnit UNIT = TimeUnit.SECONDS;
    public static final String WAIT_FOR_PUSHING = "WAIT_FOR_PUSHING";
    public static final String ALL_USER = "ALL_USER";
    private static Map<String, MessageSocket> clients = new ConcurrentHashMap<>();
    private static int onlineCount = 0;
    public Session session;
    private String id;
    @Autowired
    private RedisUtil redisUtil;

    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session) throws IOException {
        this.id = id;
        this.session = session;
        if(clients.get(id)==null){
            addOnlineCount();
            clients.put(id, this);
            log.info("已连接："+id);
        }
    }

    @OnClose
    public void onClose() throws IOException {
        log.info("断开连接："+id);
        clients.remove(id);
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

    public void sendMessageAllOnline(String message){
        try{
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAXIMUM_POOL_SIZE,KEEP_ALIVE_TIME,UNIT,new LinkedBlockingQueue<>(10));
            for (MessageSocket item : clients.values()) {
                threadPoolExecutor.execute(()->{
                    item.session.getAsyncRemote().sendText(message);
                });
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
            }else{
                redisUtil.add(WAIT_FOR_PUSHING,new MsgPartDTO(to,message));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendAll(String message){
        Set<Object> allUser = redisUtil.getMembers(ALL_USER);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAXIMUM_POOL_SIZE,KEEP_ALIVE_TIME,UNIT,new LinkedBlockingQueue<>(10));
        allUser.stream().forEach(user->{
            MessageSocket receiver = clients.get(user);
            if(receiver!=null){
                threadPoolExecutor.execute(()-> {
                    receiver.session.getAsyncRemote().sendText(message);
                });
            }else{
                redisUtil.add(WAIT_FOR_PUSHING,new MsgPartDTO(user.toString(),message));
            }
        });
    }
}
