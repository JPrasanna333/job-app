package com.jobapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobapp.model.Skills;

/**
 * @author PrasannaJ
 *
 */

@Repository
public interface ISkillRepository extends JpaRepository<Skills, Integer> {
	// derived query
	// public List<Skills> findByJobsJobName(String jobName);

	// custom queries
	@Query("from Skills s inner join s.jobs j  where j.jobName=?1")
	public List<Skills> findSkillsByJobName(String jobName);

	@Query("from Skills s where s.experience=?1")
	public List<Skills> findBySkillExperience(int experience);

}
