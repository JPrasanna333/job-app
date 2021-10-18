package com.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.exception.CompanyNotFoundException;
import com.jobapp.model.Company;
import com.jobapp.repository.ICompanyRepository;

/**
 * @author PrasannaJ
 *
 */
@Service // It tells the Spring that class contains the business logic.
public class CompanyServiceImpl implements ICompanyService {
	private ICompanyRepository companyRepository;

	@Autowired // It is used to inject a bean to achieve dependency injection(Setter based injection)
	public void setCompanyRepository(ICompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public Company addCompany(Company company) {
		return companyRepository.save(company);

	}

	@Override
	public Company updateCompany(Company company) {
		return companyRepository.save(company);

	}

	@Override
	public Company getCompanyById(int companyId) {
		Company companyById = companyRepository.findById(companyId).get();
		if (companyById == null) {
			throw new CompanyNotFoundException("Company was not found with the given company Id...");
		}
		return companyById;

	}

	@Override
	public void deleteCompany(int companyId) {
		Company companyById = companyRepository.findById(companyId).get();
		if (companyById == null) {
			throw new CompanyNotFoundException("Company was not found with the given company Id...");
		}
		companyRepository.deleteById(companyId);

	}

	@Override
	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}

	@Override
	public List<Company> getCompanyByJobName(String jobName) {
		List<Company> companyByJobName = companyRepository.findCompanyByJobName(jobName);
		if (companyByJobName.isEmpty()) {
			throw new CompanyNotFoundException("Company was not found with the given job name...");
		}
		return companyByJobName;
	}

	@Override
	public List<Company> getCompanyByLocation(String location) {
		List<Company> companyByLocation = companyRepository.findCompanyByLocation(location);
		if (companyByLocation.isEmpty()) {
			throw new CompanyNotFoundException("Company was not found with the given location...");
		}
		return companyByLocation;
	}

	@Override
	public List<Company> getCompanyByType(String type) {
		List<Company> companyByType = companyRepository.findCompanyByType(type);
		if (companyByType.isEmpty()) {
			throw new CompanyNotFoundException("Company was not found with the given company type...");
		}
		return companyByType;
	}

}
