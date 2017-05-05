package com.esprit.util;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import services.UserServicesRemote;
 

/**
 * @author Saria ESSID
 *
 */

@ServerEndpoint("/echo") 
public class EchoServer
{
	@EJB
	private UserServicesRemote usr;
	
	@Inject
    InjectedApplicationScoped bean;

	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
		
	@PostConstruct
	public void init()
	{
		System.out.println("***** Hello WebSocket *****");
	}
	
	/**
     * @OnOpen allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was 
     * successful.
     */
    @OnOpen
    public void onOpen(Session session)
    {
        System.out.println(session.getId() + " has opened a connection"); 
    }
 
    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
        System.out.println("Message from " + session.getId() + ": " + message);
        try
        {
        	bean.createUser(message);
            session.getBasicRemote().sendText(message);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    /**
     * The user closes the connection.
     * 
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session)
    {
        System.out.println("Session " +session.getId()+" has ended");
    }

    
}
