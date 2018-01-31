package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Privilege;

import com.mysql.jdbc.Statement;

public class ApplicationRoleObjectPrivilegeDao {

	private final String SUCCESS = "Successfull";
	private final String FAIL = "UnSuccessfull";

	public String addRoleObjPri(Map<String, String> map) {
		String sql = "Insert Into Privilege(Views,Edits) VALUES(?,?)";
		String sql2 = "INSERT INTO ApplicationRoleObjectPrivilege(ApplicationObjectId,Roleid,PrivilegeId) VALUES(?,?,?)";
		ResultSet rs = null;
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // getting auto
																										// generated key
																										// for privilege
																										// table
				PreparedStatement stmt2 = conn.prepareStatement(sql2);) {
			stmt.setBoolean(1, Boolean.parseBoolean(map.get("view")));
			stmt.setBoolean(2, Boolean.parseBoolean(map.get("edit")));
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys(); // return resultset containig autogenerated values for primary key auto
											// increment

			if (!rs.isBeforeFirst()) {
				return FAIL + "due to cant add privilege";
			} else {
				rs.next();
			}
			stmt2.setInt(1, Integer.parseInt(map.get("applicationObjectId")));
			stmt2.setInt(2, Integer.parseInt(map.get("RoleId")));
			stmt2.setInt(3, rs.getInt(1));

			stmt2.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL + "due to " + e.getMessage();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String removeRoleObjPrivilege(Map<String, String> map) {
		String sql = "Delete aoup,p from (ApplicationRoleObjectPrivilege aoup Left Join ApplicationObject ao ON  aoup.ApplicationObjectId=ao.ApplicationObjectId) Left Join Privilege p ON aoup.PrivilegeId=p.PrivilegeId where ao.applicationId=? and ao.objectId=? and aoup.RoleId=?";
		try (Connection conn = DatabaseConnection.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql); 
		) {
			stmt.setInt(1, Integer.parseInt(map.get("applicationId")));
			stmt.setInt(2, Integer.parseInt(map.get("applicationObjectId")));
			stmt.setInt(3, Integer.parseInt(map.get("RoleId")));
			int res = stmt.executeUpdate();
			if (res == 1)
				return SUCCESS;
			else
				return FAIL;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL + "due to" + e.getMessage();
		}
	}

	public String modifyRoleObjectPrivilege(Map<String, String> map) {
		String sql = "Update ApplicationRoleObjectPrivilege aoup Left Join ApplicationObject ao ON  aoup.ApplicationObjectId=ao.ApplicationObjectId Left Join Privilege p ON aoup.PrivilegeId=p.PrivilegeId SET p.views=?,p.edits=? where ao.applicationId=? and ao.applicationobjectId=? and aoup.RoleId=?;";
		try (Connection conn = DatabaseConnection.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql); // getting auto generated key for privilege table																														
		) {
			stmt.setBoolean(1, Boolean.parseBoolean(map.get("View")));
			stmt.setBoolean(2, Boolean.parseBoolean(map.get("Edit")));
			stmt.setInt(3, Integer.parseInt(map.get("applicationId")));
			stmt.setInt(4, Integer.parseInt(map.get("applicationObjectId")));
			stmt.setInt(5, Integer.parseInt(map.get("RoleId")));
			int res = stmt.executeUpdate();
			if (res == 1)
				return SUCCESS;
			else
				return FAIL;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL + "due to" + e.getMessage();
		}
	}

	public Privilege viewRoleObjectPrivilege(Map<String, String> map) {
		System.out.println("sss");
		Privilege p = null;
		ResultSet rs = null;
		String sql = "Select p.PrivilegeId,p.Views,p.Edits from ApplicationRoleObjectPrivilege aoup Left Join ApplicationObject ao ON  aoup.ApplicationObjectId=ao.ApplicationObjectId Left Join Privilege p ON aoup.PrivilegeId=p.PrivilegeId where ao.applicationId=? and ao.applicationobjectId=? and aoup.RoleId=?;";
		try (Connection conn = DatabaseConnection.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql); // getting auto generated key for privilege table																											
		) {
			stmt.setInt(1, Integer.parseInt(map.get("applicationId")));
			stmt.setInt(2, Integer.parseInt(map.get("applicationObjectId")));
			stmt.setInt(3, Integer.parseInt(map.get("RoleId")));
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("no privileged for Role object");
			} else {
				if (rs.last()) {
					p = new Privilege();
					p.setPrivilegeId(rs.getInt(1));
					p.setView(rs.getBoolean(2));
					p.setEdit(rs.getBoolean(3));
					return p;
				}
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return p;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}