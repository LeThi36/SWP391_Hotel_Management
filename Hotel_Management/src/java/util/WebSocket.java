package util;

import dao.MessageDAO;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import java.util.HashSet;
import java.util.Set;
import model.Message;

@ServerEndpoint("/websocket/{conversationId}")
public class WebSocket {

    private static Map<String, Set<Session>> conversations = Collections.synchronizedMap(new HashMap<>());

    @OnOpen
    public void onOpen(@PathParam("conversationId") String conversationId, Session session) {
        if (!conversations.containsKey(conversationId)) {
            conversations.put(conversationId, Collections.synchronizedSet(new HashSet<>()));
        }
        conversations.get(conversationId).add(session);
//        broadcast(conversationId, "New user joined", session);
    }

    @OnMessage
    public void onMessage(@PathParam("conversationId") String conversationId, String msg, Session session) {
        
        Message message = new Message();
        message.setMessage(msg);
        message.setConversationId(Integer.parseInt(conversationId));
        
        new MessageDAO().addMessage(message);
        
        broadcast(conversationId, msg, session);
    }

    @OnClose
    public void onClose(@PathParam("conversationId") String conversationId, Session session) {
        Set<Session> conversationSessions = conversations.get(conversationId);
        if (conversationSessions != null) {
            conversationSessions.remove(session);
//            broadcast(conversationId, "User disconnected", session);
            if (conversationSessions.isEmpty()) {
                conversations.remove(conversationId);
            }
        }
    }

    private void broadcast(String conversationId, String message, Session senderSession) {
        Set<Session> conversationSessions = conversations.get(conversationId);
        if (conversationSessions != null) {
            for (Session client : conversationSessions) {
                if (client.isOpen() && !client.equals(senderSession)) {
                    try {
                        client.getBasicRemote().sendText(message);
                    } catch (IOException e) {
                        System.err.println("Error broadcasting message: " + e.getMessage());
                    }
                }
            }
        }
    }
}
