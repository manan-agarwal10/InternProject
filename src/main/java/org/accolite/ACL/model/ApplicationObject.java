package org.accolite.ACL.model;

import java.util.Date;

public class ApplicationObject {

	public ApplicationObject() {
		// empty constructor
	}

	private int applicationObjectId;

	private int applicationId;
	private String objectPath;
	

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getApplicationObjectId() {
		return applicationObjectId;
	}

	public void setApplicationObjectId(int applicationObjectId) {
		this.applicationObjectId = applicationObjectId;
	}


	public String getObjectPath() {
		return objectPath;
	}

	public void setObjectPath(String objectPath) {
		this.objectPath = objectPath;
	}
}
