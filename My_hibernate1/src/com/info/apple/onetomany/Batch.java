package com.info.apple.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="r_batch")
public class Batch {
	
	@Id
	@GeneratedValue
	@Column(name="batch_id")
	private int batchId;
	private String batchMode;
	private String slot;
	@ManyToOne(cascade=CascadeType.ALL)
	Trainer trainer;
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Batch(String batchMode, String slot) {
		super();
		this.batchMode = batchMode;
		this.slot = slot;
	}

	public Batch(String batchMode, String slot, Trainer trainer) {
		super();
		this.batchMode = batchMode;
		this.slot = slot;
		this.trainer = trainer;
	}

	public int getBatchId() {
		return batchId;
	}

	public String getBatchMode() {
		return batchMode;
	}

	public String getSlot() {
		return slot;
	}
	
	public Trainer getTrainer() {
		return trainer;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public void setBatchMode(String batchMode) {
		this.batchMode = batchMode;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchMode=" + batchMode
				+ ", slot=" + slot + ", trainer=" + trainer + "]";
	}
	
	
}