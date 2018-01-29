package org.accolite.ACL.database;

import java.sql.Connection;
import java.sql.*;

import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.Privilege;

public class ApplicationDatabase {

	public ApplicationDatabase() {
	}
	
		public void addPrivilege(Privilege p) 
	{
		DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.getConnection();
		try 
		{
			String sql="Insert into privilege(view,edit) values(?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setBoolean(1, p.getView());
			st.setBoolean(2,p.getEdit());
			st.executeUpdate();
			con.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
