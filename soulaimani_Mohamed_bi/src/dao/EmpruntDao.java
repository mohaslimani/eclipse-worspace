package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.*;


public class EmpruntDao {
	
	public static int Create_database()
	{
		String sql = "CREATE TABLE Emprunt " +
                "(id INTEGER not NULL AUTO_INCREMENT," +
                " idEtud INTEGER, " + 
                " idLivre INTEGER, " + 
                " remis INTEGER, " + 
                " date INTEGER, "
                + "PRIMARY KEY (id))";; 
		System.out.println(sql);
		int ret = DaoGeneral.Update_statement(sql);
		if (ret != 0)
			System.out.println("Emprunt table is created successfully !!");
		else
			System.out.println("Emprunt table already exist");
		return ret;
	}
	
	public static int add_database(Emprunt l)
	{
		String sql = "INSERT INTO Emprunt (idEtud, idLivre, date, remis)"
				+ " VALUES "
				+ "(\'" + l.getIde() + "\', "
				+ l.getIdl() + ", "
				+ l.getDate() + " , 1 );";
		int ret = DaoGeneral.Update_statement(sql);
		return ret;
	}

	public static Emprunt[] select_all()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			
			String sql = " FROM emprunt";
			ResultSet rs =  stm.executeQuery("SELECT *" + sql);
			Emprunt[] ret = new Emprunt[DaoGeneral.Query_statement("SELECT count(*)" + sql)];
			int i = 0;
			while (rs.next())
			{
				ret[i] = new Emprunt();
				ret[i].setIde(rs.getInt("idetud"));
				ret[i].setDate(rs.getInt("date"));
				ret[i].setIdl(rs.getInt("idlivre"));
				ret[i].setRemis(rs.getInt("remis"));
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
	
	public static Livre[] Q_livre_par_etudiant(int idE)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			
			String sql = " FROM livre, emprunt "
					+ " where emprunt.idlivre = livre.id AND "
					+ "emprunt.idetud =  " + idE + " AND remis = 1;";
			System.out.println(sql);
			ResultSet rs =  stm.executeQuery("SELECT *" + sql);
			Livre[] ret = new Livre[DaoGeneral.Query_statement("SELECT count(*)" + sql)];
			int i = 0;
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
	
	public static int delete_first_by_id(int idE, int idL)
	{
		String sql = "DELETE FROM emprunt "
					+ " WHERE idEtud = " + idE
					+ " AND idLivre = " + idL
					+ " limit 1 ;";
		System.out.println(sql);
		int ret = DaoGeneral.Update_statement(sql);
		if (ret == 0)
		{
			System.out.println("id not found");
		}
		return ret;
	}
	
	public static int update_first_by_id(int idE, int idL)
	{
		String sql = "update emprunt set remis = 0"
					+ " WHERE idEtud = " + idE
					+ " AND idLivre = " + idL
					+ " AND remis = 1 limit 1 ;";
		System.out.println(sql);
		int ret = DaoGeneral.Update_statement(sql);
		if (ret == 0)
		{
			System.out.println("id not found");
		}
		return ret;
	}
}
