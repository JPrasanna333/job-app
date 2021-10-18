package com.jobapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.model.Job;
import com.jobapp.service.IJobService;

/**
 * @author PrasannaJ
 *
 */
@RestController()
@RequestMapping("/job-naukri")
public class JobController {
	IJobService jobService;

	@Autowired
	public void setJobService(IJobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/job")
	public void addJob(@RequestBody Job job) {
		jobService.addJob(job);

	}

	@DeleteMapping("/job/{jobId}")
	public void deleteJob(@PathVariable("jobId") int jobId) {
		jobService.deleteJob(jobId);
	}

	@PutMapping("/job")
	public void updateJob(@RequestBody Job job) {
		jobService.updateJob(job);
	}

	@GetMapping("/job/{jobId}")
	public void getJobById(@PathVariable("jobId") int jobId) {
		jobService.getJobById(jobId);
	}

	@GetMapping("/job/job-name/{jobName}")
	public List<Job> getByJobName(@PathVariable("jobName") String jobName) {
		return jobService.getByJobName(jobName);

	}

	@GetMapping("/job")
	public List<Job> getAllJob() {
		return jobService.getAllJob();
	}

	@GetMapping("/job/company/{name}")
	List<Job> getJobByCompanyName(@PathVariable("name") String name) {
		return jobService.getByCompanyName(name);

	}

	@GetMapping("/job/description/education/{education}")
	List<Job> getJobByEducationDescription(@PathVariable("education") String education) {
		return jobService.getByEducation(education);

	}

}
