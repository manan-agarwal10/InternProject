package org.accolite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.ApplicationUserPrivilege;
import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.model.User;

import com.mysql.jdbc.Statement;

public class ApplicationUserPrivilegeDao {

/*	public static void addApplicationUserPrivilege(HashMap<String, String> map) {
		String sql = "Insert Into Privilege(Views,Edits) VALUES(?,?)";
		String sql2 = "insert into ApplicationUserPrivilege (ApplicationId,UserId,PrivilegeId) values(?,?,?)";
		try {Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement stmt2 = conn.prepareStatement(sql2); 
			stmt.setBoolean(0, Boolean.parseBoolean(map.get("edit")));
			stmt.setBoolean(1, Boolean.parseBoolean(map.get("view")));
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			stmt.setInt(1, Integer.parseInt(map.get("applicationId")));
			stmt.setInt(2, Integer.parseInt(map.get("userId")));
			stmt.setInt(3, rs.getInt(1));
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static String addApplicationUserPrivilege(Map<String, String> map) {
		String sql = "Insert Into Privilege(Views,Edits) VALUES(?,?)";
		String sql2 = "insert into ApplicationUserPrivilege (ApplicationId,UserId,PrivilegeId) values(?,?,?)";
		try {
			Connection conn = DatabaseConnection.getConnection();
		
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement stmt2 = conn.prepareStatement(sql2);
		System.out.println(map.get("view"));
			stmt.setBoolean(1, Boolean.parseBoolean(map.get("view")));
			stmt.setBoolean(2, Boolean.parseBoolean(map.get("edit")));
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.isBeforeFirst()) 
			{
			rs.next();
			stmt2.setInt(1, Integer.parseInt(map.get("applicationId")));
			stmt2.setInt(2, Integer.parseInt(map.get("userId")));
			stmt2.setInt(3, rs.getInt(1));
			stmt2.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Error:" + e.getMessage();
		}
		return "Succesfull";
	}
/*	public static List<User> getUsersByApplication(int appid) {
		List<User> users = new ArrayList<User>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select userId,userName,p.Views,p.Edits from ApplicationUserPrivilege a,Users u,Privilege p where a.ApplicationId=" + appid+"AND a.applicationUserPrivilegeId=u.userId AND a.PrivilegeId=p.PrivilegeId";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					User u=new User();
					u.setUserId(rs.getInt(1));
					u.setUserName(rs.getString(2));
					users.add(u);
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}*/
	/*public static List<User> getUsersByApplication(int appid) {
		List<User> users = new ArrayList<User>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select userId,userName,p.Views,p.Edits from ApplicationUserPrivilege a,Users u,Privilege p where a.ApplicationId="
					+ appid + "AND a.applicationUserPrivilegeId=u.userId AND a.PrivilegeId=p.PrivilegeId";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					User u = new User();
					u.setUserId(rs.getInt(1));
					u.setUserName(rs.getString(2));
					users.add(u);
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}*/
	
	
	public static List<ApplicationUserPrivilege> getUsersByApplication(int appid) {
		  List<ApplicationUserPrivilege> lapp = new ArrayList<ApplicationUserPrivilege>();
		  try {
		   Connection conn = DatabaseConnection.getConnection();
		   String sql = "select a.userId,p.views,p.edits from ApplicationUserPrivilege a,Privilege p where a.ApplicationId=? AND a.PrivilegeId=p.PrivilegeId";
		   PreparedStatement stmt = conn.prepareStatement(sql);
		   stmt.setInt(1, appid);
		   ResultSet rs = stmt.executeQuery();
		   if (!rs.isBeforeFirst()) {
		    System.out.println("NoData");
		   } else {
		    while (rs.next()) {
		     ApplicationUserPrivilege aup = new ApplicationUserPrivilege();
		     Privilege p = new Privilege();
		     p.setView(rs.getBoolean(2));
		     p.setEdit(rs.getBoolean(3));
		     aup.setApplicationId(appid);
		     aup.setUserId(rs.getInt(1));
		     aup.setPrivilege(p);
		     lapp.add(aup);
		    }
		   }
		   conn.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return lapp;
		 }
	
	public static Privilege getUserPrivilegeByApplication(int appId,int userId) {
		Privilege p=new Privilege();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select p.Views,p.Edits from ApplicationUserPrivilege a,Privilege p where a.ApplicationId=" + appId + "AND p.PrivilegeId=a.PrivilegeId";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
				p=null;
			} else {
				while (rs.next()) {
					p.setView(rs.getBoolean(1));
					p.setEdit(rs.getBoolean(2));
					
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
