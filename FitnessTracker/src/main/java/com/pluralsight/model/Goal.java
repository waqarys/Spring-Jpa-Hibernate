package com.pluralsight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="goals")
public class Goal {

	@Id
	@GeneratedValue
	private Long id;
	
	@Range(min = 1, max = 120)
	private int minutes;

	public Long getId() {
		return id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
