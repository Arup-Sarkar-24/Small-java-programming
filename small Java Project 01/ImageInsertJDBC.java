//Dynamic Image Insert

import java.sql.*;
import java.io.*;//buffer reader
class ImageInsertJDBC{
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
			String q="insert into images(pic) values (?)";

			//get the preparedStatement object:
			PreparedStatement pstmt= con.prepareStatement(q);
			FileInputStream fis= new FileInputStream("C:\\Users\\arusarka\\OneDrive - Cisco\\Pictures\\Saved Pictures\\chad.jpg");
			pstmt.setBinaryStream(1,fis,fis.available());
			pstmt.executeUpdate();
			System.out.println("Data is inserted...");
			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}