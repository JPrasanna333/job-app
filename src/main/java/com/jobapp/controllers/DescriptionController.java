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

import com.jobapp.model.Company;
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
	public ResponseEntity<Description> addDescription(@RequestBody Description description) {
		Description newDescription = descriptionService.addDescription(description);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " New description is created");
		return ResponseEntity.ok().headers(headers).body(newDescription);

	}

	@DeleteMapping("/description/{descriptionId}")
	public ResponseEntity<String> deleteDescription(@PathVariable("descriptionId") int descriptionId) {
		descriptionService.deleteDescription(descriptionId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Description is deleted");
		return ResponseEntity.ok().headers(headers).body("Description is deleted successfully");
	}

	@PutMapping("/description")
	public void updateCompany(@RequestBody Description description) {
		descriptionService.updateDescription(description);
	}

	@GetMapping("/description/description-id/{descriptionId}")
	public ResponseEntity<Description> getDescriptionById(@PathVariable("descriptionId") int descriptionId) {
		Description updatedDescription = descriptionService.getDescriptionById(descriptionId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Description is updated");
		return ResponseEntity.ok().headers(headers).body(updatedDescription);
	}

	@GetMapping("/description")
	public List<Description> getAllDescription() {
		return descriptionService.getAllDescription();
	}

	@GetMapping("/description/job-name/{jobName}")
	public ResponseEntity<List<Description>> getDescriptionByJobName(@PathVariable("jobName") String jobName) {
		List<Description> descriptionLists = descriptionService.getDescriptionByJobName(jobName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got lists of all description");
		return ResponseEntity.ok().headers(headers).body(descriptionLists);

	}

	@GetMapping("/description/education/{education}")
	public ResponseEntity<List<Description>> getDescriptionByEducation(@PathVariable("education") String education) {
		List<Description> descriptionByEducation = descriptionService.getDescriptionByEducation(education);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got lists of all description by education");
		return ResponseEntity.ok().headers(headers).body(descriptionByEducation);
	}

	@GetMapping("/description/job-type/{jobtype}")
	public ResponseEntity<List<Description>> getDescriptionByJobType(@PathVariable("jobtype") String jobtype) {
		List<Description> descriptionByJobType = descriptionService.getDescriptionByJobType(jobtype);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got lists of all description by job type");
		return ResponseEntity.ok().headers(headers).body(descriptionByJobType);

	}

}
