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

import com.jobapp.model.Company;
import com.jobapp.service.ICompanyService;

/**
 * @author PrasannaJ
 *
 */
/*
 * It indicates that the application is rest-api and it can be considered as a
 * combination of @Controller and @ResponseBody annotations
 */
@RestController
@RequestMapping("/job-naukri")
public class CompanyController {
	private ICompanyService companyService;

	@Autowired // setter based injection
	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	@PostMapping("/company") // It maps the HTTP POST requests on the specific handler method
	public void addCompany(@RequestBody Company company) {
		companyService.addCompany(company);

	}

	@DeleteMapping("/company/{companyId}") // It maps the HTTP DELETE requests on the specific handler method
	public void deleteCompany(@PathVariable("companyId") int companyId) {
		companyService.deleteCompany(companyId);
	}

	@PutMapping("/company") // It maps the HTTP PUT requests on the specific handler method
	public void updateCompany(@RequestBody Company company) {
		companyService.updateCompany(company);
	}

	@GetMapping("/company/companyid/{companyId}") // It maps the HTTP GET requests on the specific handler method.
	// @PathVariable annotation is used to extract the values from the URI.
	public void getCompanyById(@PathVariable("companyId") int companyId) {
		companyService.getCompanyById(companyId);
	}

	@GetMapping("/company")
	public List<Company> getAllCompany() {
		return companyService.getAllCompany();
	}

	@GetMapping("/company/job-name/{jobName}")
	List<Company> getCompanyByJobName(@PathVariable("jobName") String jobName) {
		return companyService.getCompanyByJobName(jobName);

	}

	@GetMapping("/company/location/{location}")
	List<Company> getCompanyByLocation(@PathVariable("location") String location) {
		return companyService.getCompanyByLocation(location);
	}

	@GetMapping("/company/type/{type}")
	List<Company> getCompanyByType(@PathVariable("type") String type) {
		return companyService.getCompanyByType(type);

	}

}
