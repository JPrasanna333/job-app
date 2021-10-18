package com.jobapp.service;

import java.util.List;

import com.jobapp.model.Job;

/**
 * @author PrasannaJ
 *
 */
public interface IJobService {
	// CRUD operation methods
	void addJob(Job job);

	void updateJob(Job job);

	Job getJobById(int jobId);

	void deleteJob(int jobId);

	// Others jobMethods
	List<Job> getAllJob();

	List<Job> getByJobName(String jobName);

	List<Job> getByCompanyName(String companyName);

	List<Job> getByEducation(String education);

}
