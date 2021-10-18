package com.jobapp.service;

import java.util.List;

import com.jobapp.model.Company;

/**
 * @author PrasannaJ
 *
 */
public interface ICompanyService {
	// CRUD operation methods
	Company addCompany(Company Company);

	Company updateCompany(Company company);

	Company getCompanyById(int companyId);

	void deleteCompany(int companyId);

	// Other Methods
	List<Company> getAllCompany();

	List<Company> getCompanyByJobName(String jobName);

	List<Company> getCompanyByLocation(String location);

	List<Company> getCompanyByType(String type);

}
