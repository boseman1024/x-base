package com.axisx.servermessage.task;

import com.axisx.apimessage.dto.MsgPartDTO;
import com.axisx.servermessage.socket.MessageSocket;
import com.axisx.xutil.util.RedisUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;
import java.util.Set;

public class PushWatchJob extends QuartzJobBean {
    @Autowired
    private RedisUtil redisUtil;
    private Map<String, MessageSocket> client;

    @Override
    public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        client = MessageSocket.getClients();
        Set<Object> pushItems = redisUtil.getMembers(MessageSocket.WAIT_FOR_PUSHING);
        if(pushItems!=null){
            pushItems.stream().forEach(pushItem->{
                MsgPartDTO msgPart = (MsgPartDTO)pushItem;
                MessageSocket receiver = client.get(msgPart.getTo());
                if(receiver!=null){
                    receiver.session.getAsyncRemote().sendText(msgPart.getMessage());
                    redisUtil.removeMember(MessageSocket.WAIT_FOR_PUSHING,pushItem);
                }
            });
        }
    }
}
