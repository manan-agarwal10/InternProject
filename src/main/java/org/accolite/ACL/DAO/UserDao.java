package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.accolite.ACL.database.AESCrypt;
import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.User;

public class UserDao {
	public static final String SUCCESS="Successfull"; 
	public static final String FAIL="Unsuccessfull"; 
	
	private UserDao() {
	}

	public static String save(User u) {
		String sql = "insert into Users (Username,UserPassword) values(?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, u.getUserName());
			stmt.setString(2, AESCrypt.encrypt(u.getUserPassword()));
			stmt.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL+"due to"+e.getMessage();
		}
	}

	public static List<User> getAllUsers() {
		List<User> lapp = new ArrayList<>();
		String sql = "select * from Users";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					User u = new User();
					u.setUserId(rs.getInt(1));
					u.setUserName(rs.getString(2));
					u.setUserPassword(AESCrypt.decrypt(rs.getString(3)));
					u.setLastModifiedDate(rs.getTimestamp(4).toLocalDateTime());
					lapp.add(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return lapp;
	}

	public static boolean checkUser(User u) {
		boolean res = false;
		ResultSet rs=null;
		String sql = "select *  from Users where userName=? AND userPassword=?";
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);)
			{
			stmt.setString(1, u.getUserName());
			stmt.setString(2, AESCrypt.encrypt(u.getUserPassword()));
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				if (rs.next()) {
					u.setUserId(rs.getInt(1));
					res = true;
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public static String delete(String userName) {
		String sql = "DELETE FROM Users WHERE UserName=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userName);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL+"due to" + e.getMessage();
		}
		return SUCCESS;
	}
}
