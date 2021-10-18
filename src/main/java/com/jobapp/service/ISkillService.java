package com.jobapp.service;

import java.util.List;

import com.jobapp.model.Skills;

/**
 * @author PrasannaJ
 *
 */
public interface ISkillService {
	// CRUD Methods
	Skills addSkills(Skills skill);

	Skills updateSkills(Skills skill);

	void deleteSkills(int skillId);

	Skills getSkillsById(int skillId);
	// Others Skill methods

	List<Skills> getAllSkill();

	List<Skills> getSkillsByJobName(String jobName);

	List<Skills> getSkillByExperience(int experience);

}
