//Dynamic preparedStatement:Insert

import java.sql.*;
import java.io.*;//buffer reader
class DynamicStatementInsertJDBC{
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
			String q="insert into table1(tName,tCity) values (?,?)";

			//get the preparedStatement object:
			PreparedStatement pstmt= con.prepareStatement(q);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name :");
			String name=br.readLine();
			System.out.println("Enter city :");
			String city=br.readLine();

			//set the values to query
			pstmt.setString(1,name);
			pstmt.setString(2,city);
			pstmt.executeUpdate();
			System.out.println("Data is inserted...");
			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}