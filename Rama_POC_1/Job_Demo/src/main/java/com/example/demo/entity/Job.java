package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Size(min = 2, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "jobTitle",nullable=false)
	@NotBlank(message="jobTitle cannot be Blank")
	private String jobTitle;	
	
	@Size(min = 2, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "jobDescription",nullable=false )
	@NotBlank(message="Job Desciption cannot be Blank")
	private String jobDescription;
	
	@Size(min = 2, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "country",nullable=false)
	@NotBlank(message="country cannot be Blank")
	private String country;	
	
	@Size(min = 2, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "state",nullable=false)
	@NotBlank(message="state cannot be Blank")
	private String state;	

	@Size(min = 2, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "availability",nullable=false)
	@NotBlank(message="availability cannot be Blank")
	private String availability;
 
	@Size(min = 1, max = 200, message = "Plase enter atleast 1 Digit")
	@Column(name = "replyRate",nullable=false)
	@NotBlank(message="replyRate cannot be Blank")
	private Integer replyRate;
	
	@Size(min = 1, max = 200, message = "Plase enter atleast 1 Digit")
	@Column(name = "payRate",nullable=false )
	@NotBlank(message="payRate cannot be Blank")
	private Integer payRate;
		
	@Size(min = 1, max = 200, message = "Plase enter atleast 1 Digit")
	@Column(name = "experience",nullable = false)
	@NotBlank(message="experience cannot be Blank")
	private Integer experience;
	
	@Size(min = 4, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "skills" ,nullable=false)
	@NotBlank(message="skills cannot be Blank")
	private String skills;
	
	@Size(min = 2, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "language",nullable=false)
	@NotBlank(message="language cannot be Blank")
	private String language;
	
	@Size(min = 2, max = 200, message = "Plase enter atleast 2 characers")
	@Column(name = "jobType",nullable=false)
	@NotBlank(message="jobType cannot be Blank")
	private String jobType;  
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UserInfo userInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Integer getReplyRate() {
		return replyRate;
	}

	public void setReplyRate(Integer replyRate) {
		this.replyRate = replyRate;
	}

	public Integer getPayRate() {
		return payRate;
	}

	public void setPayRate(Integer payRate) {
		this.payRate = payRate;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", country="
				+ country + ", state=" + state + ", availability=" + availability + ", replyRate=" + replyRate
				+ ", payRate=" + payRate + ", experience=" + experience + ", skills=" + skills + "]";
	}

}
