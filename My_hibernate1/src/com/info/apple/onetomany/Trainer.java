package com.info.apple.onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Trainer")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Trainer {

	@Id
	@GeneratedValue
	@Column(name="trainer_id")
	private int trainerId;
	public Trainer(String name) {
		super();
		this.name = name;
	}

	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="trainer")
	
	Set<Batch> batches;

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(String name, Set<Batch> batches) {
		super();
		this.name = name;
		this.batches = batches;
	}

	public Set<Batch> getBatches() {
		return batches;
	}

	public String getName() {
		return name;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name
				+ ", batches=" + batches + "]";
	}
}