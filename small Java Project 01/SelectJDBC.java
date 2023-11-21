//Dynamic Image Insert

import java.sql.*;
import java.io.*;//buffer reader
class SelectJDBC{
	public static void main(String[] args) {

		try{
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//creating a connection
			String url="jdbc:mysql://localhost:3306/check_jdbc";
			String username="root";
			String password="278756";

			Connection con=DriverManager.getConnection(url,username,password);
			//Create a query
			String q="select * from table1";
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			while(set.next()){
				int id=set.getInt(1);
				String name=set.getString(2);
				String city=set.getString(3);
				System.out.println(name+" : "+city+" : "+id);

			}

			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}