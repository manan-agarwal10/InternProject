package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Privilege;

public class PrivilegeDao {
	private static Privilege myPrivilegeDao;

	private PrivilegeDao() {
	}

	public static Privilege getInstance() {
		if (myPrivilegeDao == null) {
			myPrivilegeDao = new Privilege();
		}
		return myPrivilegeDao;
	}

	public static String save(Privilege p) {
		String sql = "insert into Privilege (views,edits) values(?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setBoolean(1, p.getView());
			stmt.setBoolean(2, p.getEdit());
			stmt.executeUpdate();
			return "Successfull";
		} catch (Exception e) {
			e.printStackTrace();
			return "UnSuccessfull";
		}
	}

	public static void delete(int pid) {
		String sql = "DELETE FROM Privilege WHERE PrivilegeId=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, pid);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Privilege getPrivilegeById(int privilegeId) {
		Privilege p = new Privilege();
		ResultSet rs=null;
		String sql = "select * from application where PrivilegeId=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, privilegeId);
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				p = new Privilege();
				p.setPrivilegeId(rs.getInt(1));
				p.setView(rs.getBoolean(2));
				p.setEdit(rs.getBoolean(3));
				;
				return p;
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	public static List<Privilege> getAllPrivilege() {
		List<Privilege> lapp = new ArrayList<Privilege>();
		String sql = "select * from Privilege";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					Privilege p = new Privilege();
					p.setPrivilegeId(rs.getInt(1));
					p.setView(rs.getBoolean(2));
					p.setView(rs.getBoolean(3));
					lapp.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lapp;
	}
}
