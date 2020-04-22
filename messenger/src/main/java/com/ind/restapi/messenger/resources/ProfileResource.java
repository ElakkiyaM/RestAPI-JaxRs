package com.ind.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ind.restapi.messenger.model.Profile;
import com.ind.restapi.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	ProfileService prflsvc = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getAllProfiles() {
		return prflsvc.getAllProfiles();
	}

}
