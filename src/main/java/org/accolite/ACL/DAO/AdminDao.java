package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.accolite.ACL.database.AESCrypt;
import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Admin;

public class AdminDao {
	
	private AdminDao() {}
	public static final String SUCCESS="Successfull";
	public static final String FAIL="UnSuccessfull";
	static final Logger LOGGER = Logger.getLogger(AdminDao.class.getName());
	
	public static boolean checkAdmin(Admin ad) {
		boolean res=false;
		String sql = "select *  from Admin where adminName=? AND AdminPassword=? ";
		ResultSet rs=null;
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, ad.getAdminName());
			stmt.setString(2,AESCrypt.encrypt(ad.getAdminPassword()));
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				LOGGER.severe("cant add admin");
			} else {
				if(rs.next()) {
					ad.setAdminId(rs.getInt(1));
					res=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public static String save(Admin ad) {
		String sql = "insert into Admin (AdminName,AdminPassword,lastModifiedDate) values(?,?,?)";
		try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, ad.getAdminName());
			stmt.setString(2, AESCrypt.encrypt(ad.getAdminPassword()));
			java.sql.Timestamp sqlt=new Timestamp(new Date().getTime());
			stmt.setTimestamp(3, sqlt);
			stmt.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString());
			return FAIL+e.getMessage();
		}
	}
	
	public static String delete(String adminName) {
		String sql = "DELETE FROM Admin WHERE AdminName=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, adminName);
			stmt.executeUpdate();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString());
			return FAIL+"due to" + e.getMessage();
		}
		return SUCCESS;
	}
}
