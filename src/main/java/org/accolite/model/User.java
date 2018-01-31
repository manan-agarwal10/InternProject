package org.accolite.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="user")

public class User {

	public User() {
		//empty constructor
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	
	
	

}
