package org.accolite.ACL.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/ACL";

	 
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public static Connection getConnection() {
	   Connection conn = null;
	   try{
	      Class.forName(JDBC_DRIVER);

	      
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      return conn;
	     
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   return null;

	}
	}


