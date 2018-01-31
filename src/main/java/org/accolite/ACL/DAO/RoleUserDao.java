package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Role;

public class RoleUserDao {
	private RoleUserDao() {
	}

	public static String addRoleUser(Map<String, String> map) {
		System.out.println("Gone:");
		String sql = "insert into RoleUser (RoleId,UserId) values(?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, Integer.parseInt(map.get("roleId")));
			stmt.setInt(2, Integer.parseInt(map.get("userId")));
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error:" + e.getMessage();
		}
		return "Succesfull";
	}

	public static List<Role> getRoleByUser(int userId) {
		List<Role> lapp = new ArrayList<>();
		String sql = "select a.roleId,r.roleName,r.lastModifiedDate from RoleUser a,Role r where a.UserId=? AND a.RoleId=r.RoleId";
		ResultSet rs = null;
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					Role r = new Role();
					r.setRoleId(rs.getInt(1));
					r.setRoleName(rs.getString(2));
					r.setLastModifiedDate(rs.getTimestamp(3).toLocalDateTime());
					lapp.add(r);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
