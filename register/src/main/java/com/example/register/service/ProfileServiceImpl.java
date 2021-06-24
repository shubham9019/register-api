package com.example.register.service;


import com.example.register.model.Profile;
import com.example.register.repository.ProfileRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository repository;
	
	
	@Override
	public void add(Profile profile) {
		repository.save(profile);
		
	}

	@Override
	public Profile getProfile(String username) {
		
		return repository.getById(username);
	}

	@Override
	public List<Profile> getAllProfiles() {
		
		return repository.findAll();
	}

	@Override
	public String getProfileData(String username) {
		if (repository.existsById(username)) {
			Profile profile = repository.getById(username);
			return createProfilePage(profile);
		} else {
			return "<h1>Username not found</h1>";
		}
	}

	@Override
	public void deleteProfile(String username) {

		repository.delete(repository.getById(username));
	}

	private String createProfilePage(Profile profile) {
		String html = "<html>\n" +
				"    <head>\n" +
				"        <title>Result</title>\n" +
				"        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n" +
				"    </head>\n" +
				"    <body>\n" +
				"        <center><h1>Result</h2></center>\n" +
				"        <table class=\"table table-borderless\">\n" +
				"            <tr>\n" +
				"                <td>Name</td>\n" +
				"                <td id=\"name_val\">"+profile.getName()+"</td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td>Username</td>\n" +
				"                <td id=\"username_val\">"+profile.getUsername()+"</td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td>Email</td>\n" +
				"                <td id=\"email_val\">"+profile.getEmail()+"</td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td>Mobile</td>\n" +
				"                <td id=\"mobile_val\">"+profile.getMobile()+"</td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td>Gender</td>\n" +
				"                <td id=\"gender_val\">"+profile.getGender()+"</td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td>Skills</td>\n" +
				"                <td id=\"skills_val\">"+profile.getSkills()+"</td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td>State</td>\n" +
				"                <td id=\"state_val\">"+profile.getState()+"</td>\n" +
				"            </tr>\n" +
				"        </table>\n" +
				"    </body>\n" +
				"</html>\n" +
				"\n" +
				"\n";
		return html;
	}

}
