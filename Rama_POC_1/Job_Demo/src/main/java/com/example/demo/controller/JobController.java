package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.Job;
import com.example.demo.errors.ErrorResponse;
import com.example.demo.errors.ResponseMessages;
import com.example.demo.excel.ExcelHelper;
import com.example.demo.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService service;

	private static final Logger log = Logger.getLogger(UserInfoController.class.getName());

	@PostMapping(value = "/postjob", produces = { "application/json", "application/xml" })
	public Job save(@Valid @RequestBody Job job) {
		log.debug("---Into the PostJob Method---");
		return  service.saveJob(job);
	
	}

	@GetMapping(value = "/getJob/{id}", produces = { "application/json", "application/xml" })
	public Optional<Job> getJobById(@PathVariable("id") int id) throws com.example.demo.errors.JobIDNotFoundException {
		log.debug("---Into the getJobById Method---");
			return service.getJobById(id);
	}

	@GetMapping(value = "/getByType/{jobType}", produces = { "application/json", "application/xml" })
	public List<Job> findJobByType(@PathVariable("jobType") String jobType) {
		log.debug("---Into the findJobByType Method---");
		return service.findJobByJobType(jobType);
	}

	@GetMapping(value = "/getByExp/{exp}", produces = { "application/json", "application/xml" })
	public List<Job> findJobByExperience(@PathVariable("exp") int exp) {
		log.debug("---Into the findJobByExperience Method---");
		return service.findJobByExperience(exp);
	}

	@GetMapping(value = "/getByCountry/{country}", produces = { "application/xml", "application/json" })
	public List<Job> findJobByCountry(@PathVariable String country) {
		log.debug("---Into the findJobByCountry Method---");
		return service.findJobByCountry(country);
	}

	@GetMapping(value = "/getByLanguage/{language}", produces = { "application/xml", "application/json" })
	public List<Job> findJobByLanguage(@PathVariable String language) {
		log.debug("---Into the findJobByLanguage Method---");
		return service.findJobByLanguage(language);
	}

	@GetMapping(value = "/getByAvailability/{availability}", produces = { "application/xml", "application/json" })
	public List<Job> findByAvailability(@PathVariable("availability") String availability) {
		log.debug("---Into the findByAvailability Method---");
		return service.getDetailsByAvailability(availability);
	}

	@GetMapping(value = "/getalljobs", produces = { "application/xml", "application/json" })
	public ResponseEntity<Object> findAll() {
		log.debug("---Into the getalljobs Method---");
		try {
			service.findAllJobs1();
		} catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setTimestamp(LocalDateTime.now());
			error.setStatusCode("409");
			error.setStatusMessage("cannot get Data");
			return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
		}
		return null;
	}

	@GetMapping(value = "/getBySkills/{skills}", produces = { "application/xml", "application/json" })
	public List<Job> findBySkillsContaining(@PathVariable String skills) {
		log.debug("---Into the findBySkillsContaining Method---");
		return service.findJobBySkillsContaining(skills);
	}
	
	@PostMapping("/processjobexcel")
	public ResponseEntity<ResponseMessages> uploadFile(@RequestParam("file") MultipartFile file) {
		log.info("Xl file Data posting success.........");
		log.debug("Data posted.......");
		String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	    	  service.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessages(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessages(message));
	      	    }		
	}
	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessages(message));
	}

	@GetMapping(value = "/getByPayRate/{low}/{high}", produces = { "application/json", "application/xml" })
	public List<Job> getByPayRate(@PathVariable Integer low, @PathVariable Integer high) {
		log.debug("---Into the getByPayRate Method---");
		List<Job> job = service.findByPayRateBetween(low, high);
		return job;
	}

}
