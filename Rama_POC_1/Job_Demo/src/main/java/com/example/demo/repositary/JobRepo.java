package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

	@Query("SELECT e FROM Job e WHERE e.id = :id")
	public Job findById(int id);

	@Query("SELECT e FROM Job e WHERE e.jobType = :name")
	public List<Job> getDetailsByJobType(String name); 

	@Query("SELECT e FROM Job e WHERE e.experience = :exp")
	public List<Job> getDetailsByExperience(int exp);

	@Query("SELECT e FROM Job e WHERE e.country = :country")
	public List<Job> getDetailsByCountry(String country);

	@Query("SELECT e FROM Job e WHERE e.language = :language")
	public List<Job> findJobByLanguage(String language);
	
	@Query("SELECT e FROM Job e WHERE e.availability = :availability")
	public List<Job> getDetailsByAvailability(String availability);

	@Query("SELECT e FROM Job e WHERE e.skills = :skills ")
	public List<Job> findBySkills(String skills);

	@Query("SELECT e FROM Job e WHERE e.payRate BETWEEN ?1 AND ?2")
	public List<Job> getDetailsByPayRate(int min, int max);

	@Query("SELECT e FROM Job e WHERE e.jobType = :jobType")
	public List<Job> getDetailByJobType(String jobType);
}
