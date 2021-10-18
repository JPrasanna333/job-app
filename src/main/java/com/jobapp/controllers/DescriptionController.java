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

import com.jobapp.model.Description;
import com.jobapp.service.IDescriptionService;

/**
 * @author PrasannaJ
 *
 */
@RestController()
@RequestMapping("/job-naukri")
public class DescriptionController {
	private IDescriptionService descriptionService;

	@Autowired

	public void setDescriptionService(IDescriptionService descriptionService) {
		this.descriptionService = descriptionService;
	}

	@PostMapping("/description")
	public void addDescription(@RequestBody Description description) {
		descriptionService.addDescription(description);

	}

	@DeleteMapping("/description/{descriptionId}")
	public void deleteDescription(@PathVariable("descriptionId") int descriptionId) {
		descriptionService.deleteDescription(descriptionId);
	}

	@PutMapping("/description")
	public void updateCompany(@RequestBody Description description) {
		descriptionService.updateDescription(description);
	}

	@GetMapping("/description/description-id/{descriptionId}")
	public void getDescriptionById(@PathVariable("descriptionId") int descriptionId) {
		descriptionService.getDescriptionById(descriptionId);
	}

	@GetMapping("/description")
	public List<Description> getAllDescription() {
		return descriptionService.getAllDescription();
	}

	@GetMapping("/description/job-name/{jobName}")
	List<Description> getDescriptionByJobName(@PathVariable("jobName") String jobName) {
		return descriptionService.getDescriptionByJobName(jobName);

	}

	@GetMapping("/description/education/{education}")
	List<Description> getDescriptionByLocation(@PathVariable("education") String education) {
		return descriptionService.getDescriptionByEducation(education);
	}

	@GetMapping("/description/job-type/{jobtype}")
	List<Description> getDescriptionByJobType(@PathVariable("jobtype") String jobtype) {
		return descriptionService.getDescriptionByJobType(jobtype);

	}

}
