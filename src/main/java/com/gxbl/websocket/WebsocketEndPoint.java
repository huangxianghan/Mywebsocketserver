package com.gxbl.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 * @author xianghan
 */
public class WebsocketEndPoint extends TextWebSocketHandler {

    /**
     * 这里是链接建立时触发
     * @param session 每个客户端有一个session，向该seession发送消息，服务器就会推送到客户端
     * 你可以在连接创建的时候把session记录到一个静态列表里，总之anyway把客户
     * 端记录下来以便以后可以推送消息。
     * @throws Exception 
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session); 
    }
    
    /**
     * 这里是链接关闭时触发
     * @param session
     * @param status
     * @throws Exception 
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status); 
    }

    /**
     * 这里是客户端发送消息时触发
     * @param session
     * @param message
     * @throws Exception 
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        
        //这里是客户端传过来的字符串消息，可以是json串自己转换处理
        String clientMessage = message.getPayload();
        
        TextMessage msg = new TextMessage("服务器已经收到你的消息:"+clientMessage);
        
        //简单的echo，每个客户端有一个session，向该seession发送消息，服务器就会推送到客户端。
        session.sendMessage(msg);
        
    }
    
}
