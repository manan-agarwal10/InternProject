package org.accolite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.accolite.ACL.database.AESCrypt;
import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.model.User;


public class UserDao {

	private UserDao() {
	}

	public static void save(User u) {
		String sql = "insert into Privilege (Username,Passwrd) values(?,?)";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql); 
			stmt.setString(1, u.getUserName());
			stmt.setString(2, AESCrypt.encrypt(u.getPassword()));
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User getUserById(int userId) {
		User u = null;
		String sql = "select * from Users where UserId=?";
		try {
			Connection conn = DatabaseConnection.getConnection();
		
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, userId);
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(AESCrypt.decrypt(rs.getString(3)));
				conn.close();
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
