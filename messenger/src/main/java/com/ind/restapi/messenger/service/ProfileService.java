package com.ind.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ind.restapi.messenger.database.DatabaseClass;
import com.ind.restapi.messenger.model.Profile;

public class ProfileService {

	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Scorpion Scaffold", new Profile("SS", "Scorpion Scaffold", "Elakkiya", "M"));
		profiles.put("Dancing Daffodil", new Profile("DD", "Dancing Daffodil", "Aadhvick Sai", "E"));
		profiles.put("King Fisher", new Profile("KF", "King Fisher", "Nagenthiran", "M"));		
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profiles.put(profile.getProfileName(), profile);
	}
}
