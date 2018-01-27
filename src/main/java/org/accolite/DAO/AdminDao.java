package org.accolite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Admin;

public class AdminDao {
	private static AdminDao myAdminDao;
	
	private AdminDao() {}
	public static AdminDao getInstance() 
	{
		if(myAdminDao==null) 
		{
			myAdminDao=new AdminDao();
			return myAdminDao;
		}
		else return myAdminDao;
	}
	public static boolean checkAdmin(Admin ad) {
		boolean res=false;
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select *  from Admin where adminName=? AND AdminPassword=?";
			System.out.println(sql);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ad.getAdminName());
			stmt.setString(2,ad.getAdminPassword());
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				if(rs.next()) {
					ad.setAdminId(rs.getInt(1));
					res=true;
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
}
