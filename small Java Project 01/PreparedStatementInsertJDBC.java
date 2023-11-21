//preparedStatement:Insert

import java.sql.*;
class PreparedStatementInsertJDBC{
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

			//set the values to query
			pstmt.setString(1,"Ankita Adhikari");
			pstmt.setString(2,"Siliguri");
			pstmt.executeUpdate();
			System.out.println("Data is inserted...");
			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}