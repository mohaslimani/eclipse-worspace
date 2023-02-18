package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoGeneral {

	public static int Update_statement(String sql) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();
			int ret = stm.executeUpdate(sql);
			conn.close();
			return ret;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public static int Query_statement(String sql) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			ResultSet array =  stm.executeQuery(sql);
			
			array.next();
			int ret = array.getInt(1);
			conn.close();
			return ret;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public static int drop_table(String table_name)
	{
		String sql = "drop table " + table_name + ";";
		return Update_statement(sql);
	}
	
	public static int delete_all_table(String table_name)
	{
		String sql = "TRUNCATE TABLE " + table_name + ";";
		return Update_statement(sql);
	}
	
	public static int get_size(String table_name)
	{
		String sql = "select count(*) from " + table_name;
		return Query_statement(sql);
	}
	
	public static int delete_by_id(String table_name, int id)
	{
		String sql = "DELETE FROM " + table_name + " WHERE id = " + id + " ;";
		System.out.println(sql);
		int ret = DaoGeneral.Update_statement(sql);
		if (ret == 0)
		{
			System.out.println("id not found");
		}
		return ret;
	}
	
	public static int update_by_id(String table_name, String column, int id, String neww)
	{
		String		sql = "UPDATE " + table_name
						+ " SET " + column + " = \'" + neww
						+ "\' WHERE id = " + id + " ;";
		System.out.println(sql);
		int ret = DaoGeneral.Update_statement(sql);
		if (ret == 0)
		{
			System.out.println("id not found");
		}
		return ret;
	}
}