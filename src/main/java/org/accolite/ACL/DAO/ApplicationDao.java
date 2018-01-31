package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Application;

public class ApplicationDao {
	private ApplicationDao() {}
	public static String save(Application app) {
		if(app==null)return null;
		String sql = "insert into application (applicationName,lastModifiedDate) values(?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, app.getApplicationName());
			java.sql.Timestamp sqlt=new Timestamp(new Date().getTime());
			stmt.setTimestamp(2, sqlt);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "Unsuccesfull";
		}
		return "Successfull";
	}

	public static String delete(String appName) {
		String sql = "DELETE FROM application WHERE ApplicationName=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1,appName);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "Unsuccesfull due to" + e.getMessage();
		}
		return "Succesfull";
	}

	public static List<Application> getAllApplication() {
		List<Application> lapp = new ArrayList<>();
		String sql = "select * from application";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					Application app = new Application();
					app.setApplicationId(rs.getInt(1));
					app.setApplicationName(rs.getString(2));
					app.setLastModifiedDate(rs.getTimestamp(3).toLocalDateTime());
					lapp.add(app);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lapp;
	}
	
	public static int getApplicationId(String appName) {
		int id=-1;
		String sql = "select * from application where applicationName=?";
		ResultSet rs=null;
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, appName);
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				if(rs.next()) {
					id=rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}
}
