package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.ApplicationRolePrivilege;
import org.accolite.ACL.model.Privilege;

public class ApplicationRolePrivilegeDao {
	private ApplicationRolePrivilegeDao() {
	}

	public static String addApplicationRolePrivilege(Map<String, String> map) {
		System.out.println("Gone:");
		String sql = "Insert Into Privilege(Views,Edits) VALUES(?,?)";
		String sql2 = "insert into ApplicationRolePrivilege (ApplicationId,RoleId,PrivilegeId) values(?,?,?)";
		ResultSet rs=null;
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
			stmt.setBoolean(1, Boolean.parseBoolean(map.get("view")));
			stmt.setBoolean(2, Boolean.parseBoolean(map.get("edit")));
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.isBeforeFirst()) {
				rs.next();
				stmt2.setInt(1, Integer.parseInt(map.get("applicationId")));
				stmt2.setInt(2, Integer.parseInt(map.get("RoleId")));
				stmt2.setInt(3, rs.getInt(1));
				stmt2.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Error:" + e.getMessage();
		}
		finally {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Succesfull";
	}

	public static List<ApplicationRolePrivilege> getRolesByApplication(int appid) {
		List<ApplicationRolePrivilege> lapp = new ArrayList<>();
		String sql = "select a.RoleId,p.views,p.edits from ApplicationRolePrivilege a,Privilege p where a.ApplicationId=? AND a.PrivilegeId=p.PrivilegeId";

		ResultSet rs = null;
		try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);)
			{
			stmt.setInt(1, appid);
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					ApplicationRolePrivilege aup = new ApplicationRolePrivilege();
					Privilege p = new Privilege();
					p.setView(rs.getBoolean(2));
					p.setEdit(rs.getBoolean(3));
					aup.setApplicationId(appid);
					aup.setRoleId(rs.getInt(1));
					aup.setPrivilege(p);
					aup.setLastModifiedDate(rs.getTimestamp(3).toLocalDateTime());
					lapp.add(aup);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public static Privilege getRolePrivilegeByApplication(int appId, int RoleId) {
		Privilege p = new Privilege();
		ResultSet rs = null;
		String sql = "select p.Views,p.Edits from ApplicationRolePrivilege a,Privilege p where a.ApplicationId=? AND p.PrivilegeId=a.PrivilegeId AND a.RoleId=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);)
			{
			stmt.setInt(1, appId);
			stmt.setInt(2, RoleId);
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
				p = null;
			} else {
				while (rs.next()) {
					p.setView(rs.getBoolean(1));
					p.setEdit(rs.getBoolean(2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
}
