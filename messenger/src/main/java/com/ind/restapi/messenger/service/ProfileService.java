package com.ind.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ind.restapi.messenger.database.DatabaseClass;
import com.ind.restapi.messenger.model.Profile;

public class ProfileService {

	private static Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put(1l, new Profile(1l, "Scorpion Scaffold", "Elakkiya", "M"));
		profiles.put(2l, new Profile(2l, "Dancing Daffodil", "Aadhvick Sai", "E"));
		profiles.put(3l, new Profile(3l, "King Fisher", "Nagenthiran", "M"));		
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
}
