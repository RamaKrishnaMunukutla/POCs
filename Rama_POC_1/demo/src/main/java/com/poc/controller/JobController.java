package com.poc.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.poc.model.Job;
import com.poc.response.ErrorResponse;
import com.poc.response.SuccessResponse;
import com.poc.service.JobService;
import com.poc.utility.ExcelHelper;

@RestController
@RequestMapping("job")
public class JobController {

	@Autowired
	private JobService jobService;

	ErrorResponse errorResponse = new ErrorResponse();
	Logger logger = Logger.getLogger(this.getClass());

	@PostMapping("/postjob")
	public ResponseEntity<Object> createJob(@RequestBody Job job) {
		logger.debug("incoming request for createJob JobController ::::" + job);
		if (job.getJobTitle() != null && !job.getJobTitle().isEmpty() && job.getJobDescription() != null
				&& !job.getJobDescription().isEmpty() && job.getCountry() != null && !job.getCountry().isEmpty()
				&& job.getState() != null && !job.getState().isEmpty() && job.getAvailability() != null
				&& !job.getAvailability().isEmpty() && job.getReplyRate() >= 0 && job.getPayRate() >= 0
				&& job.getExperience() >= 0 && job.getSkills() != null && !job.getSkills().isEmpty()
				&& job.getLanguage() != null && !job.getLanguage().isEmpty() && job.getJobType() != null
				&& job.getUserInfo().getUserName() != null && !job.getUserInfo().getUserName().isEmpty()) {

			SuccessResponse createjob = jobService.createJob(job);
			logger.debug("response for createJob JobController ::::" + createjob);
			return new ResponseEntity<Object>(createjob, HttpStatus.OK);
		} else {
			logger.debug("incoming request for createJob JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
		
//		 @GetMapping("/employees")
//		    public ResponseEntity<List<Job>> getAllEmployees(
//		                        @RequestParam(defaultValue = "0") Integer pageNo, 
//		                        @RequestParam(defaultValue = "10") Integer pageSize,
//		                        @RequestParam(defaultValue = "id") String sortBy) 
//		    {
//		        List<Job> list = jobService.getAllEmployeesByPagination(pageNo, pageSize, sortBy);
//		 
//		        return new ResponseEntity<List<Job>>(list, new HttpHeaders(), HttpStatus.OK); 
//		    }

	

	@GetMapping("getjob/{id}")
	public ResponseEntity<Object> findJobById(@PathVariable int id) {
		logger.debug("incoming request for findJobById JobController ::::" + id);
		if (id >= 0) {
			SuccessResponse jobById = jobService.getJobById(id);
			logger.debug("response for findJobById JobController ::::" + jobById);
			return new ResponseEntity<Object>(jobById, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findJobById JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping("getByType/{type}")
	public ResponseEntity<Object> findJobByType(@PathVariable String type) {
		logger.debug("incoming request for findJobByType JobController ::::" + type);
		if (!type.isEmpty()) {
			SuccessResponse jobByType = jobService.getJobByType(type);
			logger.debug("response for findJobByType JobController ::::" + jobByType);
			return new ResponseEntity<Object>(jobByType, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findJobByType JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@GetMapping("getByExp/{exp}")
	public ResponseEntity<Object> findJobByExp(@PathVariable int exp) {
		logger.debug("incoming request for findJobByExp JobController ::::" + exp);
		if (exp >= 0) {
			SuccessResponse JobByExp = jobService.getJobByExp(exp);
			logger.debug("response for findJobByExp JobController ::::" + JobByExp);
			return new ResponseEntity<Object>(JobByExp, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findJobByExp JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@GetMapping("getByCountry/{country}")
	public ResponseEntity<Object> findJobByCountry(@PathVariable String country) {
		logger.debug("incoming request for findJobByCountry JobController ::::" + country);
		if (country != null) {
			SuccessResponse JobByCountry = jobService.getJobByCountry(country);
			logger.debug("response for findJobByCountry JobController ::::" + JobByCountry);
			return new ResponseEntity<Object>(JobByCountry, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findJobByCountry JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@GetMapping("getByAvailability/{availability}")
	public ResponseEntity<Object> findJobByAvailability(@PathVariable String availability) {
		logger.debug("incoming request for findJobByAvailability JobController ::::" + availability);
		if (availability != null) {
			SuccessResponse JobByAvailability = jobService.getJobByAvailability(availability);
			logger.debug("response for findJobByAvailability JobController ::::" + JobByAvailability);
			return new ResponseEntity<Object>(JobByAvailability, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findJobByAvailability JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@GetMapping("getByLanguage/{language}")
	public ResponseEntity<Object> findJobByLanguage(@PathVariable String language) {
		logger.debug("incoming request for findJobByLanguage JobController ::::" + language);
		if (language != null) {
			SuccessResponse JobByLanguage = jobService.getJobByLanguage(language);
			logger.debug("response for findJobByLanguage JobController ::::" + JobByLanguage);
			return new ResponseEntity<Object>(JobByLanguage, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findJobByLanguage JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@GetMapping("getByPayRate/{low}/{high}")
	public ResponseEntity<Object> findJobByPayrate(@PathVariable("low") int low, @PathVariable("high") int high) {
		logger.debug("incoming request for findJobByPayrate JobController ::::" + low + " " + high);

		if (low >= 0 && high >= 0) {
			SuccessResponse jobByPayRate = jobService.getJobByPayRate(low, high);
			logger.debug("response for findJobByPayrate JobController ::::" + low + " " + high);
			return new ResponseEntity<Object>(jobByPayRate, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findJobByPayrate JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@GetMapping("getalljobs")
	public ResponseEntity<Object> findAllJobs() {

		SuccessResponse getAllJobs = jobService.getAllJobs();
		logger.debug("response for getAllJobs JobController ::::" + getAllJobs);
		if (getAllJobs != null) {
			return new ResponseEntity<Object>(getAllJobs, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findAllJobs JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@GetMapping("getBySkills/{skills}")
	public ResponseEntity<Object> findBySkills(@PathVariable String skills) {
		logger.debug("incoming request for findJobByLanguage JobController ::::" + skills);
		SuccessResponse getJobBySkills = jobService.getJobBySkills(skills);
		logger.debug("response for getAllJobs JobController ::::" + getJobBySkills);
		if (getJobBySkills != null) {
			return new ResponseEntity<Object>(getJobBySkills, HttpStatus.OK);
		} else {
			logger.debug("incoming request for findBySkills JobController ::::" + "Invalid Job request");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Invalid Job request");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@PostMapping("/processjobexcel")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (ExcelHelper.hasExcelFormat(file)) {
			try {
				SuccessResponse save = jobService.save(file);
				logger.debug("file uploaded successfully");
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return new ResponseEntity<Object>(save,HttpStatus.OK);
			} catch (Exception e) {
				errorResponse.setStatusCode("422");
				errorResponse.setStatusMessage(e.getMessage());
				logger.error("error response for uploadFile JobController ::::" + e.getMessage());
				return new ResponseEntity<Object>(errorResponse, HttpStatus.EXPECTATION_FAILED);
			}
		}
		errorResponse.setStatusCode("400");
		errorResponse.setStatusMessage("Please upload an excel file!");
		return new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
