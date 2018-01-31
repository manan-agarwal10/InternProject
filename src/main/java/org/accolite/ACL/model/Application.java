package org.accolite.ACL.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Application {

	private int applicationId;
	private String applicationName;
	private LocalDateTime lastModifiedDate;

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime localDateTime) {
		this.lastModifiedDate = localDateTime;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int appId) {
		this.applicationId = appId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
