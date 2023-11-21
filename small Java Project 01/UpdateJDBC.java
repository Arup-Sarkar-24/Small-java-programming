//Dynamic Image Insert

import java.sql.*;
import java.io.*;//buffer reader
class UpdateJDBC{
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
			String q="update table1 set tName=? , tCity=? where tId=?";
			BufferedReader br= new BufferedReader (new InputStreamReader(System.in));

			System.out.println("Enter new Name : ");
			String name=br.readLine();
			System.out.println("Enter new city Name : ");
			String city=br.readLine();
			System.out.println("Enter the id : ");
			String id=br.readLine();

			//get the preparedStatement object:
			PreparedStatement pstmt= con.prepareStatement(q);
			pstmt.setString(1,name);
			pstmt.setString(2,city);
			pstmt.setString(3,id);
			pstmt.executeUpdate();
			System.out.println("Data is updated...");
			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}