package com.jobapp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author PrasannaJ
 *
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Company {
	@Id
	@GeneratedValue(generator = "company_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "company_id", sequenceName = "company_seq", initialValue = 1, allocationSize = 1)
	private Integer companyId;
	@Column(length = 20)
	private String location;
	@Column(name = "companyname")
	private String name;
	@Column(length = 20)
	private String type;
	@Column(name = "companysize")
	private Long companySize;

	@OneToMany(fetch = FetchType.EAGER) // creates new table company_jobs
	@JsonIgnore
	@JoinColumn(name = "company_id")
	private Set<Job> jobs;

	/**
	 * @param location
	 * @param name
	 * @param type
	 * @param companySize
	 */
	public Company(String location, String name, String type, Long companySize) {
		super();
		this.location = location;
		this.name = name;
		this.type = type;
		this.companySize = companySize;
	}

}
