package org.accolite.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Application;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationDao {
	public static String save(Application app) {
		int res=0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "insert into application (applicationName) values(?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, app.getApplicationName());
			res=stmt.executeUpdate();
			System.out.println("executed"+res);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(res==1) return "Successfull";
		else return "Unsuccesfull";
	}

	public static void delete(int appid) {

		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "DELETE FROM application WHERE ApplicationId=" + appid;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Application getApplicationById(int appid) {
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select * from application where ApplicationId=" + appid;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				Application app = new Application();
				app.setApplicationId(rs.getInt(1));
				app.setApplicationName(rs.getString(2));
				return app;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Application> getAllApplication() {
		List<Application> lapp = new ArrayList<Application>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select * from application";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					Application app = new Application();
					app.setApplicationId(rs.getInt(1));
					app.setApplicationName(rs.getString(2));

				/*	//converting java.sql.Date to java.util.date
					java.sql.Date d = rs.getDate(4);
					java.util.Date d2 = new Date(d.getTime());
					app.setLastModifiedDate(d2);
				*/
					lapp.add(app);
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lapp;
	}

}
