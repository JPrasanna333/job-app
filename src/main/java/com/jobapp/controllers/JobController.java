package com.jobapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
	private IJobService jobService;

	@Autowired
	public void setJobService(IJobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/job")
	public ResponseEntity<Job> addJob(@RequestBody Job job) {
		Job newJob = jobService.addJob(job);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " New job is created");
		return ResponseEntity.ok().headers(headers).body(newJob);

	}

	@DeleteMapping("/job/{jobId}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobId") int jobId) {
		jobService.deleteJob(jobId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " Job is update");
		return ResponseEntity.ok().headers(headers).body("Job is updated successfully");
	}

	@PutMapping("/job")
	public ResponseEntity<Job> updateJob(@RequestBody Job job) {
		Job updatedJob = jobService.updateJob(job);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Job is updated");
		return ResponseEntity.ok().headers(headers).body(updatedJob);
	}

	@GetMapping("/job/{jobId}")
	public ResponseEntity<Job> getJobById(@PathVariable("jobId") int jobId) {
		Job jobById = jobService.getJobById(jobId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got a Job by id");
		return ResponseEntity.ok().headers(headers).body(jobById);
	}

	@GetMapping("/job/job-name/{jobName}")
	public ResponseEntity<List<Job>> getByJobName(@PathVariable("jobName") String jobName) {
		List<Job> jobsByName = jobService.getByJobName(jobName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all job by job name");
		return ResponseEntity.ok().headers(headers).body(jobsByName);

	}

	@GetMapping("/job")
	public ResponseEntity<List<Job>> getAllJob() {
		List<Job> jobList = jobService.getAllJob();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all jobs");
		return ResponseEntity.ok().headers(headers).body(jobList);

	}

	@GetMapping("/job/company/{name}")
	public ResponseEntity<List<Job>> getJobByCompanyName(@PathVariable("name") String name) {
		List<Job> jobsByCompanyName = jobService.getByCompanyName(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all job by company name");
		return ResponseEntity.ok().headers(headers).body(jobsByCompanyName);

	}

	@GetMapping("/job/description/education/{education}")
	public ResponseEntity<List<Job>> getJobByEducationDescription(@PathVariable("education") String education) {
		List<Job> jobsByEducationDescription = jobService.getByEducation(education);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all job by education under description");
		return ResponseEntity.ok().headers(headers).body(jobsByEducationDescription);

	}

}
