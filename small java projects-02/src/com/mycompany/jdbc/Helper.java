package com.mycompany.jdbc;
import java.awt.Image;
import java.io.InputStream;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Helper {
	public static ImageIcon getImageIconById(int id, Connection con) {
		ImageIcon icon=null;
		try {
			
			String q="select pic images where id=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1, id);
			ResultSet set=pstmt.executeQuery();
			if (set.next()) {
				Blob b=set.getBlob("Pic");
				InputStream is=b.getBinaryStream();
				Image image=ImageIO.read(is);
				icon=new ImageIcon(image);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return icon;
	}

}
