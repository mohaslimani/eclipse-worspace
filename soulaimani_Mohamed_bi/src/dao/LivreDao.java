package dao;

import beans.*;
import java.sql.*;

public class LivreDao {
	
	public static Livre[] select_all () 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			ResultSet rs =  stm.executeQuery("SELECT * FROM LIVRE");
			
			Livre[] ret = new Livre[DaoGeneral.get_size("LIVRE")];
			int i = 0;
			//Livre rr = new Livre();
			while (rs.next())
			{
				ret[i] = new Livre();
				ret[i].setId(rs.getInt("id"));
				ret[i].setTitre(rs.getString("titre"));
				ret[i].setDate(rs.getInt("date"));
				ret[i].setStock(rs.getInt("stock"));
				ret[i].setEdit(rs.getInt("edit"));
				i++;
			}
			conn.close();
			return ret;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static Livre select_one (int id) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			ResultSet rs =  stm.executeQuery("SELECT * FROM LIVRE where id = " + id);
			
			rs.next();
			Livre ret = new Livre();
			ret.setId(rs.getInt("id"));
			ret.setTitre(rs.getString("titre"));
			ret.setDate(rs.getInt("date"));
			ret.setStock(rs.getInt("stock"));
			ret.setEdit(rs.getInt("edit"));
			conn.close();
			return ret;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static int Create_Livre_database()
	{
		String sql = "CREATE TABLE LIVRE " +
                "(id INTEGER not NULL AUTO_INCREMENT," +
                " titre VARCHAR(255), " + 
                " edit INTEGER, " + 
                " date INTEGER, " +
                " stock INTEGER," 
                + "PRIMARY KEY (id))";
		int ret = DaoGeneral.Update_statement(sql);
		if (ret != 0)
			System.out.println("Livre table is created successfully !!");
		else
			System.out.println("Livre table already exist");
		return ret;
	}
	
	public static int add_Livre_database(Livre l)
	{
		String sql = "INSERT INTO LIVRE (titre, edit, date, stock)"
				+ " VALUES "
				+ "(\'" + l.getTitre() + "\', "
				+ l.getEdit() + ", "
				+ l.getDate() + ", "
				+ l.getStock() + ");";
		int ret = DaoGeneral.Update_statement(sql);
		return ret;
	}
	
	public static int update_stock(int st, int id)
	{
		String sql = "UPDATE livre "
				+ "SET stock = " + st
				+ " WHERE id = " + id + " ;";
		System.out.println(sql);
		int ret = DaoGeneral.Update_statement(sql);
		if (ret == 0)
		{
			System.out.println("id not found");
		}
		return ret;
	}
	
	public static int add_Livres_table(Livre[] l) 
	{
		int ret = 0;
		
		for (Livre var : l) 
		{
			 ret += add_Livre_database(var);
		}
		return ret;
	}
	
}

