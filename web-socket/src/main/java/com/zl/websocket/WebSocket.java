package com.zl.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/14 19:11
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocket {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     **/
    private static int onlineCount = 0;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。
     **/
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     **/
    private Session session;

    /**
     * 连接建立成功
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        // 加入set中
        webSocketSet.add(this);
        addOnlineCount();
        try {
//            sendInfo("有新连接加入！当前在线人数为" + getOnlineCount());
            sendMessage("当前在线人数为" + getOnlineCount());
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);

        //群发消息
        for (WebSocket item : webSocketSet) {
            try {
                item.sendMessage(session.getId() + "发送：" + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) {
        for (WebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                return;
            }
        }
    }

    /**
     * 获取在线人数
     *
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 添加在线人数
     */
    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    /**
     * 删除在线人数
     */
    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}