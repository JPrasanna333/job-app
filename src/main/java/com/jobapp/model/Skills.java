package com.jobapp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

public class Skills {
	@Id
	@GeneratedValue(generator = "skill_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "skill_id", sequenceName = "skill_seq", initialValue = 1, allocationSize = 1)
	private Integer skillId;
	@Column(name = "skillname", length = 20)
	private String skillName;
	private int experience;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "skillsLists")
	@JsonIgnore
	private Set<Job> jobs;

	/**
	 * @param skillName
	 * @param experience
	 */
	public Skills(String skillName, int experience) {
		super();
		this.skillName = skillName;
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Skills [skillName=" + skillName + ", experience=" + experience + "]";
	}

}
