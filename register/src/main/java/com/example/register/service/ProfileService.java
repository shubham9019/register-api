package com.example.register.service;

import com.example.register.model.Profile;

import java.util.List;

public interface ProfileService {
	void add(Profile profile);
	
	Profile getProfile(String username);
	
	List<Profile> getAllProfiles();

	String getProfileData(String username);

	void deleteProfile(String username);
}
