package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.*;

public class EtudiantDao {
	
	public static Etudiant[] select_all () 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			ResultSet rs =  stm.executeQuery("SELECT * FROM Etudiant");
			
			Etudiant[] ret = new Etudiant[DaoGeneral.get_size("Etudiant")];
			int i = 0;
			while (rs.next())
			{
				ret[i] = new Etudiant();
				ret[i].setId(rs.getInt("id"));
				ret[i].setNom(rs.getString("nom"));
				ret[i].setPrenom(rs.getString("prenom"));
				ret[i].setFil(rs.getString("fil"));
				ret[i].setCin(rs.getString("cin"));
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
	
	public static Etudiant select_one (int id) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			ResultSet rs =  stm.executeQuery("SELECT * FROM Etudiant where id = " + id);
			
			rs.next();
			Etudiant ret = new Etudiant();
			ret.setId(rs.getInt("id"));
			ret.setNom(rs.getString("nom"));
			ret.setPrenom(rs.getString("prenom"));
			ret.setFil(rs.getString("fil"));
			ret.setCin(rs.getString("cin"));
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
	
	public static int Create_etud_database()
	{
		String sql = "CREATE TABLE Etudiant " +
                "(id INTEGER not NULL AUTO_INCREMENT," +
                " nom VARCHAR(255), " + 
                " prenom VARCHAR(255), " + 
                " cin VARCHAR(255), " +
                " fil VARCHAR(255)," 
                + "PRIMARY KEY (id))"; 
		int ret = DaoGeneral.Update_statement(sql);
		if (ret != 0)
			System.out.println("Etudiant table is created successfully !!");
		else
			System.out.println("Etudiant table already exist");
		return ret;
	}
	
	public static int add_etud_database(Etudiant l)
	{
		String sql = "INSERT INTO Etudiant (nom, prenom, cin, fil)"
				+ " VALUES "
				+ "(\'" + l.getNom() + "\', "
				+ "\'" + l.getPrenom() + "\', "
				+ "\'" + l.getCin() + "\', "
				+ "\'" + l.getFil() + "\' "
				 + ");";
		System.out.println(sql);
		int ret = DaoGeneral.Update_statement(sql);
		return ret;
	}
}
