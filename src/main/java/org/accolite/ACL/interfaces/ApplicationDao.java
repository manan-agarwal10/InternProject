package org.accolite.ACL.interfaces;

import java.util.List;

import org.accolite.ACL.model.Application;

public interface ApplicationDao {
	String save(Application app);

	void delete(int appid);

	Application getApplicationById(int appid);

	List<Application> getAllApplication();

}
