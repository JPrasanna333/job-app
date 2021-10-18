package com.jobapp.service;

import java.util.List;

import com.jobapp.model.Description;

/**
 * @author PrasannaJ
 *
 */
public interface IDescriptionService {
	// CRUD methods
	Description addDescription(Description description);

	Description updateDescription(Description description);

	Description getDescriptionById(int descriptionId);

	void deleteDescription(int descriptionId);

	// Others description methods
	List<Description> getAllDescription();

	List<Description> getDescriptionByJobName(String jobName);

	List<Description> getDescriptionByEducation(String education);

	List<Description> getDescriptionByJobType(String jobType);

}
