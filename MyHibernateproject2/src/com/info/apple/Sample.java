package com.info.apple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
			name="getAllSample",
			query="select * from sample_table",
			resultClass=Sample.class
			)
})
@NamedQueries({
	@NamedQuery(
			name="getAllSamples",
			query="from Sample"
			
			)
}
		)

@Entity
@Table(name="sample_table")
public class Sample {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sampleId;
	@Column(name="sample_name")
	private String name;
	private int randonNumber;
	
	
	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sample(String name) {
		super();
		this.name = name;
	}
	public Sample(String name, int randonNumber) {
		super();
		this.name = name;
		this.randonNumber = randonNumber;
	}
	public String getName() {
		return name;
	}
	
	@Transient
	public int getRandonNumber() {
		return randonNumber;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRandonNumber(int randonNumber) {
		this.randonNumber = randonNumber;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	@Override
	public String toString() {
		return "Sample [sampleId=" + sampleId + ", name=" + name + "]";
	}
	
}
