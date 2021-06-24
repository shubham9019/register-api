package com.example.register.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Profile {
	@Id
	@Column(name="username")
	@NotNull
	private String username;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="mobile")
	@NotNull
	private Long mobile;
	
	@Column(name="gender")
	@NotNull
	private  String gender;
	
	@Column(name="skills")
	@NotNull
	private String skills;
	
	@Column(name="state")
	@NotNull
	private String state;
	
	@Column(name="profilePic")
	@NotNull
	private String profilePic;



}
