package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Role;

public class RoleDao {
	public static final String SUCCESS="Successfull"; 
	public static final String FAIL="Unsuccessfull"; 
	
	private RoleDao() {
	}

	public static String save(Role r) {
		String sql = "insert into Role(RoleName) values(?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, r.getRoleName());
			stmt.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL+"due to"+e.getMessage();
		}
	}

	public static List<Role> getAllRoles() {
		List<Role> lapp = new ArrayList<>();
		String sql = "select * from Role";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					Role u = new Role();
					u.setRoleId(rs.getInt(1));
					u.setRoleName(rs.getString(2));
					System.out.println(rs.getTimestamp(3));
					u.setLastModifiedDate(rs.getTimestamp(3).toLocalDateTime());
					System.out.println(u.getLastModifiedDate());
					lapp.add(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lapp;
	}

	public static String delete(String roleName) {
		String sql = "DELETE FROM Role WHERE RoleName=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, roleName);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL+"due to" + e.getMessage();
		}
		return SUCCESS;
	}
}
