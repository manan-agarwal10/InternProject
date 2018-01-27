package org.accolite.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.ApplicationObject;

public class ApplicationObjectDao {

	public static void save(ApplicationObject ao) {
		String sql = "insert into applicationObject (ApplicationId,ObjectPath) values(?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, ao.getApplicationId());
			stmt.setString(2,ao.getObjectPath());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(int appObjId) {
		String sql = "DELETE FROM ApplicationObject WHERE ApplicationObjectId=" + appObjId;
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<ApplicationObject> getObjectByApplication(Application app) {
		List<ApplicationObject> lapp = new ArrayList<>();
		String sql = "select * from ApplicationObject where ApplicationId=" + app.getApplicationId();

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					ApplicationObject ao=new ApplicationObject();
					ao.setApplicationId(rs.getInt(2));
					ao.setApplicationObjectId(rs.getInt(1));
					ao.setObjectPath(rs.getString(3));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lapp;
	}

}
