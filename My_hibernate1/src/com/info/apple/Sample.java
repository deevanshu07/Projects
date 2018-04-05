package com.info.apple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sample_table")
public class Sample {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int sampleId;
	private String name;
	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sample(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	@Override
	public String toString() {
		return "Sample [sampleId=" + sampleId + ", name=" + name + "]";
	}
	
}
