package com.eb.test.servicesImpli.cheng;
 
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap; 
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
 


@ServerEndpoint(value="/websocket/{userId}") 
@Component
@Slf4j
public class WebSocketService {
	
	public static Map<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@OnOpen
	public void onOpen(@PathParam("userId") String userId,Session session) {
		log.info("WebSocketService onOpen: "+userId);
		if(sessionMap == null) {
			sessionMap = new ConcurrentHashMap<String, Session>();
		}
		sessionMap.put(userId, session);
	}
	
	@OnClose
	public void OnClose(@PathParam("userId") String userId) {
		log.info("WebSocketService OnClose: "+userId);
		sessionMap.remove(userId);
	}
	@OnMessage
	public void OnMessage(@PathParam("userId") String userId,Session session,String message) {
		log.info("WebSocketService OnMessage: "+message);
		for(Session session_ : sessionMap.values()) {
			session_.getAsyncRemote().sendText(message);
		}
	}
	
	@OnError
	public void error(Session session, Throwable t) {
		
		t.printStackTrace();
	}
}