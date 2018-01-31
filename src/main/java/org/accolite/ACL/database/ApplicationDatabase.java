package org.accolite.ACL.database;

import java.sql.Connection;
import java.sql.*;

import org.accolite.ACL.model.Application;

public class ApplicationDatabase {

	public ApplicationDatabase() {
	}
	
	public void addApplication(Application app)
	{
		DatabaseConnection dc = new DatabaseConnection();
		try {
			Connection conn = dc.getConnection();

		
			String sql = "insert into application (app_name,last_modified_date,admin_id) values(?,?,?)";
		System.out.println("1");
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,"rahul" );
		Date d = new Date(System.currentTimeMillis());
		
		stmt.setDate(2, d);
		stmt.setInt(3, 1);
		System.out.println("2");
		stmt.executeUpdate();
		System.out.println("executed");
		conn.close();
	
	
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

}
}
