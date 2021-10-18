package com.jobapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author PrasannaJ
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Job {
	@Id
	@GeneratedValue(generator = "job_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "job_id", sequenceName = "job_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "jobid", length = 20)
	private Integer jobId;
	@Column(name = "jobname", length = 20)
	private String jobName;

	@ManyToOne(cascade = CascadeType.ALL) // add company_id in job table
	// @JsonIgnore
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToMany(fetch = FetchType.EAGER)
	// @JsonIgnore
	@JoinTable(name = "job_skillsLists", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private Set<Skills> skillsLists;

	@OneToOne(cascade = CascadeType.ALL)
	// @JsonIgnore
	@JoinColumn(name = "description_id")
	Description description;

	/**
	 * @param jobName
	 * @param company
	 * @param skillsLists
	 * @param description
	 */
	public Job(String jobName, Company company, Set<Skills> skillsLists, Description description) {
		super();
		this.jobName = jobName;
		this.company = company;
		this.skillsLists = skillsLists;
		this.description = description;
	}

}
