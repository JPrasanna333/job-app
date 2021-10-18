package com.jobapp.service;

import java.util.List;

import com.jobapp.model.Skills;

/**
 * @author PrasannaJ
 *
 */
public interface ISkillService {
	// CRUD Methods
	void addSkills(Skills skill);

	void updateSkills(Skills skill);

	void deleteSkills(int skillId);

	Skills getSkillsById(int skillId);
	// Others Skill methods

	List<Skills> getAllSkill();

	List<Skills> getSkillsByJobName(String jobName);

	List<Skills> getSkillBySkillName(String skillName);

	List<Skills> getSkillByExperience(int experience);

}
