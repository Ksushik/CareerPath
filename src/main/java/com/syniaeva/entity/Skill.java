package com.syniaeva.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {

	@Id
	@GeneratedValue
	@Column(name = "SKILL_ID")
	private Long id;

	@Column(name = "NAME", length = 655, nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "TOPIC_ID", nullable = false)
	private Topic topic;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "POSITION_ID", nullable = false)
	private Position position;

	@Column(name = "DESCR")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position topic) {
		this.position = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Skill that = (Skill) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(topic, that.topic) &&
				Objects.equals(position, that.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, topic, position);
	}

}
