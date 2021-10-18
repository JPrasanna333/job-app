package com.jobapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobapp.model.Job;

/**
 * @author PrasannaJ
 *
 */
@Repository//This annotation is a DAOs (Data Access Object) that access the database directly. The repository does all the operations related to the database.
public interface IJobRepository extends JpaRepository<Job, Integer> {
	// Derived query
	List<Job> findByJobName(String jobName);

	List<Job> findByCompanyName(String company);

	// List<Job> findByDescriptionEducation(String education);

	// native query
	// @Query(value = "select * from job j inner join description d on j.jobid=d.description_id where d.education = ?", nativeQuery = true)
	
	// Custom query
	@Query("from Job j inner join j.description d where d.education =?1")
	List<Job> findByDescEducation(String education);

}
