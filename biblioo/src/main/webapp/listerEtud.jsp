<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTER LES ETUDIANT</title>
<style>
	th
	{
		border-style: solid;
	}
</style>
</head>
<body>

	<h2 style="color : red; text-align: center;">list des etudiants</h2>
	<table style="width: auto; margin : auto">
		<tr>
			<th style="background-color : yellow;">Nom</th>
			<th style="background-color : yellow;">Prenom</th>
			<th style="background-color : yellow;">filiere</th>
			<th style="background-color : yellow;">cin</th>
		</tr>
		<%
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
			
			Statement stm = conn.createStatement();

			ResultSet rs =  stm.executeQuery("SELECT * FROM Etudiant");
			
			while (rs.next())
			{
				out.println("<tr>");
				out.println("<th>" + rs.getString("nom") + "</th>");
				out.println("<th>" + rs.getString("prenom") + "</th>");
				out.println("<th>" + rs.getString("fil") + "</th>");
				out.println("<th>" + rs.getString("cin") + "</th>");
				out.println("</tr>");
			}
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		%>
	</table>

</body>
</html>