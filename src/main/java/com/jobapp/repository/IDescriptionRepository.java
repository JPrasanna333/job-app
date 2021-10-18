package com.jobapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobapp.model.Description;

/**
 * @author PrasannaJ
 *
 */

/*
 * This annotation is a DAOs (Data Access Object) that access the database
 * directly. The repository does all the operations related to the database.
 */
@Repository
public interface IDescriptionRepository extends JpaRepository<Description, Integer> {
	@Query("from Description d inner join d.job j where j.jobName=?1")
	List<Description> findDescriptionByJobName(String jobName);

	@Query("from Description d  where d.education=?1")
	List<Description> findDescriptionByEducation(String education);

	@Query("from Description d  where d.jobType=?1")
	List<Description> findDescriptionByJobType(String jobType);
}
