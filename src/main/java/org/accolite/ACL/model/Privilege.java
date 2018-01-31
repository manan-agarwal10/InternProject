package org.accolite.ACL.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Privilege {
	public Privilege() {
		//empty constructor
	}
	
	


	@Autowired
	private int privilegeId;
	
	private boolean view;
	private boolean edit;
	



	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}



	public Boolean getView() {
		return view;
	}



	public Boolean getEdit() {
		return edit;
	}



	public void setEdit(Boolean edit) {
		this.edit = edit;
	}



	public int getPrivilegeId() {
		return privilegeId;
	}

	
	public void setView(Boolean view) {
		this.view = view;
	}
	
	public Privilege(boolean view ,boolean edit) 
	{
		this.view=view;
		this.edit=edit;
	}

}
