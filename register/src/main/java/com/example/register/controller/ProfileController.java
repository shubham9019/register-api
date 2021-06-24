package com.example.register.controller;

import com.example.register.model.Profile;
import com.example.register.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class ProfileController {
	@Autowired
	private ProfileService service;
	
	@PostMapping("/profile")
	public void addProfile(@RequestParam @Valid String name,
						   @RequestParam @Valid String username,
						   @RequestParam @Valid String email,
						   @RequestParam @Valid Long mobile,
						   @RequestParam @Valid String gender,
						   @RequestParam @Valid String skills,
						   @RequestParam @Valid String state,
						   @RequestParam @Valid MultipartFile file) throws IOException {
		Profile profile = new Profile();
		profile.setName(name);
		profile.setUsername(username);
		profile.setEmail(email);
		profile.setMobile(mobile);
		profile.setGender(gender);
		profile.setSkills(skills);
		profile.setState(state);
		profile.setProfilePic(file.getBytes().toString());
		service.add(profile);
	}

	@GetMapping("/profile/{username}")
	public Profile getProfile(@PathVariable String username) {
		return service.getProfile(username);
	}
	
	@GetMapping("/profile")
	public List<Profile> getAllProfiles(){
		return service.getAllProfiles();
	}

	@GetMapping("/get_profile/{username}")
	public String getProfileData(@PathVariable String username) {
		return service.getProfileData(username);
	}
}
