package com.ind.restapi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.ind.restapi.messenger.model.Message;
import com.ind.restapi.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}

}

/* No concurrency.. and not thread safe.. Just to achieve a service stub using in memory */
