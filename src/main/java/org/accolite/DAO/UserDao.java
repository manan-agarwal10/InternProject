package org.accolite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.accolite.ACL.database.AESCrypt;
import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Admin;
import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

	private UserDao() {
	}

	public static void save(User u) {
		String sql = "insert into Privilege (Username,Passwrd) values(?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, u.getUserName());
			stmt.setString(2, AESCrypt.encrypt(u.getUserPassword()));
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User getUserById(int userId) {
		User u = null;
		String sql = "select * from Users where UserId=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			stmt.setInt(1, userId);
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserPassword(AESCrypt.decrypt(rs.getString(3)));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static List<User> getAllUsers() 
	{
		List<User> lapp=new ArrayList<>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select * from Users";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(!rs.isBeforeFirst()) 
			{
				System.out.println("NoData");
			}
			else 
			{
				while(rs.next()) 
				{
					User u=new User();
					u.setUserId(rs.getInt(1));
					u.setUserName(rs.getString(2));
					u.setUserPassword(AESCrypt.decrypt(rs.getString(3)));
					lapp.add(u);
				}
			}
			conn.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return lapp;
	}
	
	public static boolean checkUser(User u) {
		boolean res=false;
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select *  from Users where userName=? AND userPassword=?";
			System.out.println(sql);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUserName());
			stmt.setString(2,u.getUserPassword());
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				if(rs.next()) {
					u.setUserId(rs.getInt(1));
					res=true;
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}


