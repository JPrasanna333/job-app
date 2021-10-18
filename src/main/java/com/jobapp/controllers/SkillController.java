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
import com.jobapp.model.Skills;
import com.jobapp.service.ISkillService;

/**
 * @author PrasannaJ
 *
 */
@RestController
@RequestMapping("/job-naukri")
public class SkillController {
	private ISkillService skillService;

	@Autowired
	public void setSkillService(ISkillService skillService) {
		this.skillService = skillService;
	}

	@PostMapping("/skill")
	public ResponseEntity<Skills> addSkill(@RequestBody Skills skill) {
		Skills newSkill = skillService.addSkills(skill);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " New skill was created");
		return ResponseEntity.ok().headers(headers).body(newSkill);

	}

	@DeleteMapping("/skill/{skillId}")
	public ResponseEntity<String> deleteJob(@PathVariable("skillId") int skillId) {
		skillService.deleteSkills(skillId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " Skill was Deleted");
		return ResponseEntity.ok().headers(headers).body("Skill was deleted successfully");
	}

	@PutMapping("/skill")
	public ResponseEntity<Skills> updateJob(@RequestBody Skills skill) {
		Skills updatedSkill = skillService.updateSkills(skill);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Job is updated");
		return ResponseEntity.ok().headers(headers).body(updatedSkill);
	}

	@GetMapping("/skill/{skillId}")
	public ResponseEntity<Skills> getJobById(@PathVariable("skillId") int skillId) {
		Skills skillById = skillService.getSkillsById(skillId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got a Skill by id");
		return ResponseEntity.ok().headers(headers).body(skillById);
	}

	@GetMapping("/skill")
	public ResponseEntity<List<Skills>> getAllSkill() {
		List<Skills> skillsList = skillService.getAllSkill();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all skills");
		return ResponseEntity.ok().headers(headers).body(skillsList);
	}

	@GetMapping("/skill/job-name/{jobName}")
	public ResponseEntity<List<Skills>> getSkillByJobName(@PathVariable("jobName") String jobName) {
		List<Skills> skillsByJobName = skillService.getSkillsByJobName(jobName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of  skills by job name");
		return ResponseEntity.ok().headers(headers).body(skillsByJobName);
	}

	@GetMapping("/skill/experience/{experience}")
	public ResponseEntity<List<Skills>> getSkillByExperience(@PathVariable("experience") int experience) {
		List<Skills> skillsByExperience = skillService.getSkillByExperience(experience);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of  skills by experience");
		return ResponseEntity.ok().headers(headers).body(skillsByExperience);
	}

}
