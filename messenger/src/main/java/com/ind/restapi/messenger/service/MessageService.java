package com.ind.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ind.restapi.messenger.database.DatabaseClass;
import com.ind.restapi.messenger.model.Message;
import com.ind.restapi.messenger.model.Profile;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	

	public MessageService() {
		messages.put(11l, new Message(11, "Hi lets explore jax-Rs", "Elakkiya"));
		messages.put(21l, new Message(21, "This msg ID is so spl", "Nagenthiran"));
		messages.put(31l, new Message(31, "The growing little champ", "Aadhvick Sai"));
	}
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 	/*Passing a collection to arraylist constructor initialized
															 * the list with those elements	 */
	}

	public Message getMessage(long msgId) {
		return messages.get(msgId);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMEssage(Long msgId) {
		return messages.remove(msgId);
	}
}
