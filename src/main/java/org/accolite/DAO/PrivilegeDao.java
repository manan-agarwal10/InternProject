package org.accolite.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.accolite.ACL.database.DatabaseConnection;
import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.Privilege;

public class PrivilegeDao {
	private static Privilege myPrivilegeDao;
	private PrivilegeDao() {}
	public static Privilege getInstance() 
	{
		if(myPrivilegeDao==null) 
		{
			myPrivilegeDao=new Privilege();
		}
		return myPrivilegeDao;
	}
	
	public static void save(Privilege p)
	{
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "insert into Privilege (views,edits) values(?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1,p.getView() );
			stmt.setBoolean(2,p.getEdit());
			stmt.executeUpdate();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void delete(int pid)
	{
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "DELETE FROM Privilege WHERE PrivilegeId="+pid;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Privilege getPrivilegeById(int privilegeId) 
	{
		Privilege p=new Privilege();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select * from application where PrivilegeId="+privilegeId;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(!rs.isBeforeFirst()) 
			{
				System.out.println("NoData");
			}
			else 
			{
				p=new Privilege();
				p.setPrivilegeId(rs.getInt(1));
				p.setView(rs.getBoolean(2));
				p.setEdit(rs.getBoolean(3));;
				return p;
			}
			conn.close();
			return p;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return p;
	}
	
	public static List<Privilege> getAllPrivilege()
	{
		List<Privilege> lapp=new ArrayList<Privilege>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			String sql = "select * from Privilege";
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
					Privilege p=new Privilege();
					p.setPrivilegeId(rs.getInt(1));
					p.setView(rs.getBoolean(2));
					p.setView(rs.getBoolean(3));
					lapp.add(p);
				}
			}
			conn.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return lapp;
	}
}
