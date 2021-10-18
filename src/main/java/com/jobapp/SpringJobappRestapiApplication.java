package com.jobapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jobapp.model.Company;
import com.jobapp.model.Description;
import com.jobapp.model.Job;
import com.jobapp.model.Skills;
import com.jobapp.service.ICompanyService;
import com.jobapp.service.IDescriptionService;
import com.jobapp.service.IJobService;
import com.jobapp.service.ISkillService;

/**
 * @author PrasannaJ
 *
 */
@SpringBootApplication
public class SpringJobappRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJobappRestapiApplication.class, args);
	}

	@Autowired// It is used to inject a bean to achieve dependency injection
	IJobService jobService;
	@Autowired
	IDescriptionService decriptionService;
	@Autowired
	ICompanyService companyService;
	@Autowired
	ISkillService skillService;

	@Override
	public void run(String... args) throws Exception {
		// One to one & many to one
		Description description1 = new Description("Full time", "Btech", 550000, 1);

		Company company1 = new Company("bangalore", "Hcl", "Private", 120000l);

		Skills skill1 = new Skills("Java", 1);
		// skillService.addSkills(skill1);
		Skills skill2 = new Skills("Angular", 1);
		// skillService.addSkills(skill2);
		Set<Skills> skillLists = new HashSet<>(Arrays.asList(skill1, skill2));

		Job job1 = new Job("Developer", company1, skillLists, description1);
		// jobService.addJob(job1);

		// Set<Job> jobList = new HashSet<>(Arrays.asList(job1, job2));

		// Skills skill1 = new Skills("Java", 5);
//		Skills skill2 = new Skills("Angular", 3);
//		Set<Skills> skillLists = new HashSet<>(Arrays.asList(skill1, skill2));
//		jobService.addJob(job1);
//		jobService.addJob(job2);
//		companyService.addCompany(company);

		// one to many

		// Set<Job> jobList = new HashSet<>(Arrays.asList(job1, job2));
		// Company company = new Company("Banglore", "tcs", "Private", 45000l,jobList);

//		Skills skill1 = new Skills("Java", 5);
//		Skills skill2 = new Skills("Angular", 3);
//		Set<Skills> skillLists = new HashSet<>(Arrays.asList(skill1, skill2));
//		Job job1 = new Job("Developer", company1, skillLists, description);
//		Job job2 = new Job("Software enginner", company1, skillLists, description);
//		Set<Job> jobList = new HashSet<>(Arrays.asList(job1, job2));
//		Company company2 = new Company("Banglore", "tcs", "Private", 45000l, jobList);
//		Job job = new Job("Typing", company, skillLists, description);
//		jobService.addJob(job1);

		// jobService.getByEducation("Mechanical").forEach(System.out:: println);

	}

}
