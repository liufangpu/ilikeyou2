package site.jjilikeyou.www.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class GetHttpSessionConfigurator extends Configurator {
	 @Override
	    public void modifyHandshake(ServerEndpointConfig sec,
	            HandshakeRequest request, HandshakeResponse response) {
	        try {
				HttpSession httpSession=(HttpSession) request.getHttpSession();
				sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
			} catch (Exception e) {
				System.out.println("session已经销毁");
				e.printStackTrace();
			}
	    }
}
