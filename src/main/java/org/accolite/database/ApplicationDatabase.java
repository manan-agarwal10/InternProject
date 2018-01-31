package org.accolite.database;

import java.sql.Connection;
import java.sql.*;

import org.accolite.model.Application;

public class ApplicationDatabase {

	public ApplicationDatabase() {
	}
	
	public void addApplication(Application app)
	{
		DatabaseConnection dc = new DatabaseConnection();
		try {
			Connection conn = dc.getConnection();

		
			String sql = "insert into application (app_name,last_modified_date,admin_id) values(?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,app.getApplicationName() );
		Date d = new Date(System.currentTimeMillis());
		
		stmt.setDate(2, d);
		stmt.setInt(3, 1);
		
		stmt.executeUpdate();
		conn.close();
	
	
	}
		catch(Exception e)
		{
			
		}

}
}
