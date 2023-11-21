package com.mycompany.jdbc;
import java.sql.*;
public class ConnectionProvider{
	private static Connection con;
	public static Connection getConnection(){
		try{
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/check_jdbc";
				String username="root";
				String password="278756";
				con=DriverManager.getConnection(url,username,password);
				
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
