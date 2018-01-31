package org.accolite.ACL.model;

import org.springframework.stereotype.Component;

@Component
public class Master {

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public Master() {
		// TODO Auto-generated constructor stub
	}
	
	private int masterId;
	
	private String masterName;

}
