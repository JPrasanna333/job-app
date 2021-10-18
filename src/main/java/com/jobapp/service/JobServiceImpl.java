package com.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.exception.JobNotFoundException;
import com.jobapp.model.Job;
import com.jobapp.repository.IJobRepository;

/**
 * @author PrasannaJ
 *
 */
@Service // It tells the Spring that class contains the business logic.
public class JobServiceImpl implements IJobService {
	IJobRepository jobRepository;

	@Autowired // Setter based injection
	public void setJobRepository(IJobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public void addJob(Job job) {
		jobRepository.save(job);

	}

	@Override
	public void updateJob(Job job) {
		jobRepository.save(job);

	}

	@Override
	public Job getJobById(int jobId) {
		Job jobById = jobRepository.findById(jobId).get();
		if (jobById == null) {
			throw new JobNotFoundException("Job was not found with given jobid..");
		}
		return jobById;
	}

	@Override
	public void deleteJob(int jobId) {
		if (jobRepository.findById(jobId).get() == null) {
			throw new JobNotFoundException("Job was not found with the given jobid..");
		}
		jobRepository.deleteById(jobId);

	}

	@Override
	public List<Job> getAllJob() {
		return jobRepository.findAll();
	}

	@Override
	public List<Job> getByJobName(String jobName) {
		List<Job> jobByJobName = jobRepository.findByJobName(jobName);
		if (jobByJobName.isEmpty()) {
			throw new JobNotFoundException("Job was not found with the given job name..");
		}
		return jobByJobName;

	}

	@Override
	public List<Job> getByCompanyName(String companyName) {
		List<Job> jobByCompanyName = jobRepository.findByCompanyName(companyName);
		if (jobByCompanyName.isEmpty()) {
			throw new JobNotFoundException("Job was not found with the given company name..");
		}
		return jobByCompanyName;

	}

	@Override
	public List<Job> getByEducation(String education) {
		List<Job> jobByEducation = jobRepository.findByDescEducation(education);
		if (jobByEducation.isEmpty()) {
			throw new JobNotFoundException("Job was not found with the given company name..");
		}
		return jobByEducation;

	}

}
