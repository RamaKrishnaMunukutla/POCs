package com.poc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.poc.model.Job;
import com.poc.response.SuccessResponse;

public interface JobService {
	SuccessResponse createJob(Job job);

	SuccessResponse getJobById(int id);

	SuccessResponse getJobByType(String jobType);

	SuccessResponse getJobByExp(int exp);

	SuccessResponse getJobByCountry(String country);

	SuccessResponse getJobByAvailability(String availability);

	SuccessResponse getJobBySkills(String skills);

	SuccessResponse getJobByLanguage(String language);

	SuccessResponse getJobByPayRate(int low, int high);

	SuccessResponse getAllJobs();

	SuccessResponse save(MultipartFile file);

	List<Job> getAllEmployeesByPagination(Integer pageNo, Integer pageSize, String sortBy);
}
