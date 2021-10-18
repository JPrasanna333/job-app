package com.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.exception.DescriptionNotFoundException;
import com.jobapp.model.Description;
import com.jobapp.repository.IDescriptionRepository;

/**
 * @author PrasannaJ
 *
 */
@Service // It tells the Spring that class contains the business logic.
public class DescriptionServiceImpl implements IDescriptionService {
	private IDescriptionRepository descriptionRepository;

	@Autowired // Setter based injection
	public void setDescriptionRepository(IDescriptionRepository descriptionRepository) {
		this.descriptionRepository = descriptionRepository;
	}

	@Override
	public Description addDescription(Description description) {
		return descriptionRepository.save(description);

	}

	@Override
	public Description updateDescription(Description description) {
		return descriptionRepository.save(description);

	}

	@Override
	public Description getDescriptionById(int descriptionId) {
		Description descriptionById = descriptionRepository.findById(descriptionId).get();
		if (descriptionById == null) {
			throw new DescriptionNotFoundException("Description was not found with the given id...");
		}
		return descriptionById;
	}

	@Override
	public void deleteDescription(int descriptionId) {
		Description descriptionById = descriptionRepository.findById(descriptionId).get();
		if (descriptionById == null) {
			throw new DescriptionNotFoundException("Description was not found with the given id...");
		}
		descriptionRepository.deleteById(descriptionId);

	}

	@Override
	public List<Description> getAllDescription() {
		return descriptionRepository.findAll();
	}

	@Override
	public List<Description> getDescriptionByJobName(String jobName) {
		List<Description> descriptionByJobName = descriptionRepository.findDescriptionByJobName(jobName);
		if (descriptionByJobName.isEmpty()) {
			throw new DescriptionNotFoundException("Description was not found with the given job name...");
		}
		return descriptionByJobName;
	}

	@Override
	public List<Description> getDescriptionByEducation(String education) {
		List<Description> descriptionByEducation = descriptionRepository.findDescriptionByEducation(education);
		if (descriptionByEducation.isEmpty()) {
			throw new DescriptionNotFoundException("Description was not found with the given education...");
		}
		return descriptionByEducation;
	}

	@Override
	public List<Description> getDescriptionByJobType(String jobType) {
		List<Description> descriptionByJobType = descriptionRepository.findDescriptionByJobType(jobType);
		if (descriptionByJobType.isEmpty()) {
			throw new DescriptionNotFoundException("Description was not found with the given job type...");
		}
		return descriptionByJobType;
	}

}
