package org.accolite.model;

import java.util.Date;



public class Objects {


	public Objects() {
		//empty constructor
	}
	
	private int objectId;
	
	
	private String path;
	
	
	private String objectName;
	
	
	
	private Date lastUpdatedDate;
	
	
	
	public int getObjectId() {
		return objectId;
	}



	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getObjectName() {
		return objectName;
	}



	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}



	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}



	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	public Application getApp() {
		return app;
	}



	public void setApp(Application app) {
		this.app = app;
	}


	private Application app;
}
