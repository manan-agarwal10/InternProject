package org.accolite.ACL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.ApplicationUserPrivilege;
import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.model.Role;

import com.mysql.jdbc.Statement;

public class ApplicationUserPrivilegeDao {
	private ApplicationUserPrivilegeDao() {
	}
	static final String SUCCESS="Successfull";
	static final String FAIL="Unsuccessfull";
	
	public static String addApplicationUserPrivilege(Map<String, String> map) {
		String sql = "Insert Into Privilege(Views,Edits) VALUES(?,?)";
		String sql2 = "insert into ApplicationUserPrivilege (ApplicationId,UserId,PrivilegeId) values(?,?,?)";
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
				stmt2.setInt(2, Integer.parseInt(map.get("userId")));
				stmt2.setInt(3, rs.getInt(1));
				stmt2.executeUpdate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return FAIL + e.getMessage();
		}
		finally {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	public static List<ApplicationUserPrivilege> getUsersByApplication(int appid) {
		List<ApplicationUserPrivilege> lapp = new ArrayList<>();
		String sql = "select a.userId,p.views,p.edits,a.lastModifiedDate from ApplicationUserPrivilege a,Privilege p where a.ApplicationId=? AND a.PrivilegeId=p.PrivilegeId";
		ResultSet rs=null;
		try 
			(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);)
			{
			stmt.setInt(1, appid);
			rs = stmt.executeQuery();
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
					aup.setLastModifiedDate(rs.getTimestamp(4).toLocalDateTime());
					lapp.add(aup);
				}
			}
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
		return lapp;
	}

	
	public static Privilege getUserPrivilegeByApplication(int appId, int userId) {
		Privilege p = new Privilege();
		ResultSet rs=null;
		String sql = "select p.Views,p.Edits from ApplicationUserPrivilege a,Privilege p where a.ApplicationId=? AND p.PrivilegeId=a.PrivilegeId AND a.UserId=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);)
			{
			//Checking privilege for user
			stmt.setInt(1,appId);
			stmt.setInt(2,userId);
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("NoData");
			} else {
				while (rs.next()) {
					p.setView(rs.getBoolean(1));
					p.setEdit(rs.getBoolean(2));
				}
			}
			
			
			//Checking its Group(Role) Privileges and taking union of permissions
			List<Role> rList=RoleUserDao.getRoleByUser(userId);
			for(Role r:rList) 
			{
				Privilege temp=ApplicationRolePrivilegeDao.getRolePrivilegeByApplication(appId, r.getRoleId());
				p.setEdit(p.getEdit()||temp.getEdit());
				p.setView(p.getView()||temp.getView());
			}
			
			
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
		return p;
	}
}
