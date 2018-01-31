package org.accolite.model;





public class Access {

	public Access() {
		//empty constructor
	}
	
	
	private int accessId;
	
	private Boolean create;
	
	
	
	private Boolean retrieve;
	
	
	private Boolean update;
	

	
	private Boolean delete;
	
	public int getAccessId() {
		return accessId;
	}



	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}



	public Boolean getCreate() {
		return create;
	}



	public void setCreate(Boolean create) {
		this.create = create;
	}



	public Boolean getRetrieve() {
		return retrieve;
	}



	public void setRetrieve(Boolean retrieve) {
		this.retrieve = retrieve;
	}



	public Boolean getUpdate() {
		return update;
	}



	public void setUpdate(Boolean update) {
		this.update = update;
	}



	public Boolean getDelete() {
		return delete;
	}



	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	
	
	
	
	

}
