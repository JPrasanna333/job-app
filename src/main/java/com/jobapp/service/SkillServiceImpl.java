package com.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.exception.SkillNotFoundException;
import com.jobapp.model.Skills;
import com.jobapp.repository.ISkillRepository;

/**
 * @author PrasannaJ
 *
 */
@Service // It tells the Spring that class contains the business logic.
public class SkillServiceImpl implements ISkillService {
	private ISkillRepository skillRepository;

	@Autowired // Setter based injection
	public void setSkillRepository(ISkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	public Skills addSkills(Skills skill) {
		return skillRepository.save(skill);

	}

	@Override
	public Skills updateSkills(Skills skill) {
		return skillRepository.save(skill);

	}

	@Override
	public void deleteSkills(int skillId) {
		if (skillRepository.findById(skillId).get() == null) {
			throw new SkillNotFoundException("Skill was not found with the given skillid..");
		}
		skillRepository.deleteById(skillId);

	}

	@Override
	public Skills getSkillsById(int skillId) {
		Skills skillById = skillRepository.findById(skillId).get();
		if (skillById == null) {
			throw new SkillNotFoundException("Skill was not found with given skillid..");
		}
		return skillById;
	}

	@Override
	public List<Skills> getAllSkill() {
		return skillRepository.findAll();
	}

	@Override
	public List<Skills> getSkillsByJobName(String jobName) {
		List<Skills> SkillsByJobName = skillRepository.findSkillsByJobName(jobName);
		if (SkillsByJobName.isEmpty()) {
			throw new SkillNotFoundException("Skill was not found with the given job name..");
		}
		return SkillsByJobName;
	}

	@Override
	public List<Skills> getSkillByExperience(int experience) {
		List<Skills> SkillsByExperience = skillRepository.findBySkillExperience(experience);
		if (SkillsByExperience.isEmpty()) {
			throw new SkillNotFoundException("Skill was not found with the given experience...");
		}
		return SkillsByExperience;
	}

}