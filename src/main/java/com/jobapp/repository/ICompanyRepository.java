package com.jobapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobapp.model.Company;

/**
 * @author PrasannaJ
 *
 */

/*
 * This annotation is a DAOs (Data Access Object) that access the database
 * directly. The repository does all the operations related to the database.
 */
@Repository
public interface ICompanyRepository extends JpaRepository<Company, Integer> {
	// derived queries
	// public List<Company> findByJobsJobName(String jobName);

	// custom queries
	@Query("from Company c inner join c.jobs j where j.jobName=?1")
	public List<Company> findCompanyByJobName(String jobName);

	@Query("from Company c  where c.location=?1")
	public List<Company> findCompanyByLocation(String location);

	@Query("from Company c  where c.type=?1")
	public List<Company> findCompanyByType(String type);

}
