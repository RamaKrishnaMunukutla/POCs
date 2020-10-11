package com.poc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poc.model.Job;

public interface JobDao extends JpaRepository<Job, Long> {

	 List<Job> findJobById(int id);
	 
	 @Query(value = "select * from job where job_type=?1", nativeQuery = true)
	 List<Job> findJobByType(String jobType);
	 
	 @Query(value = "select * from job where experience=?1", nativeQuery = true)
	 List<Job> findJobByExp(int exp);
	 
	 @Query(value = "select * from job where country=?1", nativeQuery = true)
	 List<Job> findJobByCountry(String country);
	 
	 @Query(value = "select * from job where availability=?1", nativeQuery = true)
	 List<Job> findJobByAvailability(String availability);
	 
	 @Query(value = "select * from job where skills like %?1%", nativeQuery = true)
	 List<Job> findJobBySkills(String skills);
	 
	 @Query(value = "select * from job where language=?1", nativeQuery = true)
	 List<Job> findJobByLanguage(String language);
	 
	 @Query(value = "select * from job where pay_rate between ?1 and ?2", nativeQuery = true)
	 List<Job> findJobByPayRate(int low, int high );
	 
	 
}
