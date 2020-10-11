package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.Job;
import com.example.demo.excel.ExcelHelper;
import com.example.demo.repositary.JobRepo;

@Service
public class JobService {

	@Autowired
	private JobRepo repo;

	public Job saveJob(@Valid @RequestBody Job job) {
		Job save = repo.save(job);
		return save;
	}

	public Optional<Job> getJobById(Integer id)  {
			return repo.findById(id);
		}
	 

	public List<Job> findJobByJobType(String jobType) {
		return repo.getDetailByJobType(jobType);
	}

	public List<Job> findJobByExperience(int exp) {
		return repo.getDetailsByExperience(exp);
	}

	public List<Job> findJobByCountry(String country) {
		return repo.getDetailsByCountry(country);

	}

	public List<Job> findJobByLanguage(String language) {
		return repo.findJobByLanguage(language);
	}

	public List<Job> getDetailsByJobType(String jobType) {
		return repo.getDetailsByJobType(jobType);
	}

	public List<Job> findAllJobs() {
		return repo.findAll();
	}

	public List<Job> findJobBySkillsContaining(String skills) {
		return repo.findBySkills(skills);
	}

//	public List<Job> saveAll(MultipartFile file) {
//		try {
//			System.out.println("service");
//			List<Job> jobs = ExcelHelper.excelToTutorials(file.getInputStream());
//
//			jobs.forEach(games -> System.out.println(games));
//			List<Job> saveAll = repo.saveAll(jobs);
//			System.out.println(saveAll + ">>>>>");
//			return saveAll;
//		} catch (IOException e) {
//			System.out.println("from exception");
//			throw new RuntimeException("fail to store excel data: " + e.getMessage());
//		}
//	}

	
	public void save(MultipartFile file) {
	    try {
	      List<Job> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
	      repo.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	    
	}
	    
	public List<Job> findByPayRateBetween(Integer low, Integer high) {
		return repo.getDetailsByPayRate(low, high);
	}

	public List<Job> getDetailsByAvailability(String availability) {
		return repo.getDetailsByAvailability(availability);
	}

	public List<Job> findAllJobs1() {
		return repo.findAll();
	}
}
