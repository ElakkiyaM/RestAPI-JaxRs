package com.ind.restapi.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ind.restapi.messenger.database.DatabaseClass;
import com.ind.restapi.messenger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	

	public MessageService() {
		messages.put(11l, new Message(11, "Hi lets explore jax-Rs", "Elakkiya", new Date()));
		messages.put(21l, new Message(21, "This msg ID is so spl", "Nagenthiran", new Date()));
		messages.put(31l, new Message(31, "The growing little champ", "Aadhvick Sai", new Date()));
	}
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 	/*Passing a collection to arraylist constructor initialized
															 * the list with those elements	 */
	}

	public Message getMessage(long msgId) {
		return messages.get(msgId);
	}
	
	public List<Message> getMessageForYear(int year){
		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getMessagePaginated(int start, int size){
		List<Message> msgLst = new ArrayList<>(messages.values());
		if(start+size > msgLst.size()) return new ArrayList<>();
		return (msgLst.subList(start, start+size));
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
	
	public Message removeMessage(Long msgId) {
		return messages.remove(msgId);
	}
}
