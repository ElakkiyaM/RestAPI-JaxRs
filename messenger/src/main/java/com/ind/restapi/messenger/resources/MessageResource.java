package com.ind.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ind.restapi.messenger.model.Message;
import com.ind.restapi.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgsvc = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessages() {
		return msgsvc.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long messageId) {		
		return msgsvc.getMessage(messageId);		
	}
}
