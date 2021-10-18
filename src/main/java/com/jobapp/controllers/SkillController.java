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
	public void addSkill(@RequestBody Skills skill) {
		skillService.addSkills(skill);

	}

	@DeleteMapping("/skill/{skillId}")
	public void deleteJob(@PathVariable("skillId") int skillId) {
		skillService.deleteSkills(skillId);
	}

	@PutMapping("/skill")
	public void updateJob(@RequestBody Skills skill) {
		skillService.updateSkills(skill);
	}

	@GetMapping("/skill")
	public List<Skills> getAllSkill() {
		return skillService.getAllSkill();
	}

	@GetMapping("/skill/job-name/{jobName}")
	public List<Skills> getSkillByJobName(@PathVariable("jobName") String jobName) {
		return skillService.getSkillsByJobName(jobName);
	}

	@GetMapping("/skill/skill-name/{skillName}")
	public List<Skills> getSkillBySkillName(@PathVariable("skillName") String skillName) {
		return skillService.getSkillBySkillName(skillName);
	}

	@GetMapping("/skill/experience/{experience}")
	public List<Skills> getSkillByExperience(@PathVariable("experience") int experience) {
		return skillService.getSkillByExperience(experience);
	}

}
