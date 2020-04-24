package com.ind.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ind.restapi.messenger.model.Message;
import com.ind.restapi.messenger.resources.beans.MessageFilterBean;
import com.ind.restapi.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService msgsvc = new MessageService();

	@GET
	public List<Message> getAllMessages(@BeanParam MessageFilterBean filterBean) {
		if(filterBean.getYear() > 0) {
			return msgsvc.getMessageForYear(filterBean.getYear() );
		} else if (filterBean.getStart() > 0 && filterBean.getSize() > 0) {
			return msgsvc.getMessagePaginated(filterBean.getStart() , filterBean.getSize());
		}
		return msgsvc.getAllMessages();
	}
	
	@POST	
	/* Accept the model type as argument to bind to the request body */
	public Message addMessage(Message message) {
		return msgsvc.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return msgsvc.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")	
	public String deleteMessage(@PathParam("messageId") long messageId) {
		msgsvc.removeMessage(messageId);
		return ("The message is deleted");
	}
	
	@GET
	@Path("/{messageId}")	
	public Message getMessage(@PathParam("messageId") long messageId) {		
		return msgsvc.getMessage(messageId);		
	}
}
