package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.ApplicationObject;

public class ApplicationObjectDao {
	private ApplicationObjectDao() {
	}

	public static final String SUCCESS = "Successfull";
	public static final String FAIL = "UnSuccessfull";

	public static String save(ApplicationObject ao) {
		String sql = "insert into applicationObject (ApplicationId,ObjectPath,lastModifiedDate) values(?,?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, ao.getApplicationId());
			stmt.setString(2, ao.getObjectPath());
			Timestamp sqlt = new Timestamp(new java.util.Date().getTime());
			stmt.setTimestamp(3, sqlt);
			stmt.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL + e.getMessage();
		}
	}

	public static String delete(int appObjId) {
		String sql = "DELETE FROM ApplicationObject WHERE ApplicationObjectId=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, appObjId);
			stmt.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL + e.getMessage();
		}
	}

	public static String delete(String objPath) {
		String sql = "DELETE FROM ApplicationObject WHERE ObjectPath=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, objPath);
			stmt.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL + e.getMessage();
		}
	}

	public static List<ApplicationObject> getObjectByApplication(Application app) {
		List<ApplicationObject> lapp = new ArrayList<>();
		ResultSet rs = null;
		if (app == null)
			return lapp;
		String sql = "select * from ApplicationObject ao JOIN Application a ON ao.ApplicationId=a.ApplicationId  where a.ApplicationId=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, app.getApplicationId());
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					ApplicationObject ao = new ApplicationObject();
					ao.setApplicationObjectId(rs.getInt(1));
					ao.setApplicationId(rs.getInt(2));
					ao.setObjectPath(rs.getString(3));
					ao.setLastModifiedDate(rs.getTimestamp(4).toLocalDateTime());
					lapp.add(ao);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			lapp.clear();
			return lapp;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lapp;
	}

}
