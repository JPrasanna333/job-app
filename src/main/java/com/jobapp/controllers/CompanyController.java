package com.jobapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		Company newCompany = companyService.addCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " New company is created");
		return ResponseEntity.ok().headers(headers).body(newCompany);

	}

	@DeleteMapping("/company/{companyId}") // It maps the HTTP DELETE requests on the specific handler method
	public ResponseEntity<String> deleteCompany(@PathVariable("companyId") int companyId) {
		companyService.deleteCompany(companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Company is deleted");
		return ResponseEntity.ok().headers(headers).body("Company is deleted successfully");
	}

	@PutMapping("/company") // It maps the HTTP PUT requests on the specific handler method
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		Company updatedCompany = companyService.updateCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Company is updated");
		return ResponseEntity.ok().headers(headers).body(updatedCompany);
	}

	@GetMapping("/company/companyid/{companyId}") // It maps the HTTP GET requests on the specific handler method.
	// @PathVariable annotation is used to extract the values from the URI.
	public ResponseEntity<Company> getCompanyById(@PathVariable("companyId") int companyId) {
		Company companyById = companyService.getCompanyById(companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got a company by id");
		return ResponseEntity.ok().headers(headers).body(companyById);
	}

	@GetMapping("/company")
	public ResponseEntity<List<Company>> getAllCompany() {
		List<Company> companyList = companyService.getAllCompany();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all company");
		return ResponseEntity.ok().headers(headers).body(companyList);

	}

	@GetMapping("/company/job-name/{jobName}")
	public ResponseEntity<List<Company>> getCompanyByJobName(@PathVariable("jobName") String jobName) {
		List<Company> companiesByJobName = companyService.getCompanyByJobName(jobName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all company by job name");
		return ResponseEntity.ok().headers(headers).body(companiesByJobName);

	}

	@GetMapping("/company/location/{location}")
	public ResponseEntity<List<Company>> getCompanyByLocation(@PathVariable("location") String location) {
		List<Company> companiesByLocation = companyService.getCompanyByLocation(location);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got list of all company by location");
		return ResponseEntity.ok().headers(headers).body(companiesByLocation);

	}

	@GetMapping("/company/type/{type}")
	public ResponseEntity<List<Company>> getCompanyByType(@PathVariable("type") String type) {
		List<Company> companiesBytype = companyService.getCompanyByType(type);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got lists of all company by company type");
		return ResponseEntity.ok().headers(headers).body(companiesBytype);

	}

}
