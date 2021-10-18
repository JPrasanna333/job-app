package com.jobapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class Description {
	@Id
	@GeneratedValue(generator = "desc_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "desc_id", sequenceName = "desc_seq", initialValue = 1, allocationSize = 1)
	private Integer descriptionId;
	@Column(name = "jobtype", length = 40)
	private String jobType;
	@Column(name = "education", length = 40)
	private String education;
	private double ctc;
	private int experience;
	@OneToOne(mappedBy = "description")
	@JsonIgnore
	private Job job;

	/**
	 * @param jobType
	 * @param education
	 * @param ctc
	 * @param experience
	 */
	public Description(String jobType, String education, double ctc, int experience) {
		super();
		this.jobType = jobType;
		this.education = education;
		this.ctc = ctc;
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Description [jobType=" + jobType + ", education=" + education + ", ctc=" + ctc + ", experience="
				+ experience + "]";
	}

}
