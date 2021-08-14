package com.met.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="counters")
public class Counter {

	@Id
	@Column(name="ctr_name")
	private String ctrName;
	
	@Column(name="cur_val")
	private int counterValue;

	public String getCtrName() {
		return ctrName;
	}

	public void setCtrName(String ctrName) {
		this.ctrName = ctrName;
	}

	public int getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(int counterValue) {
		this.counterValue = counterValue;
	}
	
	
	
}
