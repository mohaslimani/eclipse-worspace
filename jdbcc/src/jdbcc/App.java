package jdbcc;

import java.sql.*;

public class App {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();
			String sql = "CREATE TABLE LIVRE " +
	                   "(id INTEGER not NULL, " +
	                   " titre VARCHAR(255), " + 
	                   " edit INTEGER, " + 
	                   " date INTEGER, " + 
	                   " stock INTEGER)"; 

	         stm.executeUpdate(sql);
	         System.out.println("Created table in given database..."); 
			
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Livre is existed already");
		}
	}

}
