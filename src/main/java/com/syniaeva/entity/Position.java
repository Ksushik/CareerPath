package com.syniaeva.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {

	@Id
	@GeneratedValue
	@Column(name = "POSITION_ID")
	private Long positionId;

	@Column(name = "NAME", length=100, nullable=false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position", cascade={CascadeType.ALL})
	private List<Skill> requiredSkills;

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skill> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<Skill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
}
