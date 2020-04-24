package com.ind.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ind.restapi.messenger.database.DatabaseClass;
import com.ind.restapi.messenger.model.Profile;

public class ProfileService {

	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Scorpion Scaffold", new Profile(1l, "Scorpion Scaffold", "Elakkiya", "M"));
		profiles.put("Dancing Daffodil", new Profile(2l, "Dancing Daffodil", "Aadhvick Sai", "E"));
		profiles.put("King Fisher", new Profile(3l, "King Fisher", "Nagenthiran", "M"));		
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public String removeProfile(String profileName) {
		profiles.remove(profileName);
		return "The profile removed";
	}
}
