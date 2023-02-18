package beans;

public class Etudiant {
	int id;
	String nom;
	String prenom;
	String filiere;
	String CIN;
	
	//Constructor
	public Etudiant() 
	{
		id = 0;
		nom = "nom";
		prenom = "prenom";
		filiere = "ensa";
		CIN = "A000000";
	}
	
	public Etudiant(int id, String nom, String prenom, String fil, String cin) 
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = fil;
		this.CIN = cin;
	}
	
	//getters
	public String getNom() 
	{
		return (nom);
	}
	public String getPrenom() 
	{
		return (prenom);
	}
	public String getCin() 
	{
		return (CIN);
	}
	public String getFil() 
	{
		return (filiere);
	}
	public int getId() 
	{
		return (id);
	}
	
	//setters
	public void setNom(String name) 
	{
		this.nom = name;
	}
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	public void setCin(String cin) 
	{
		this.CIN = cin;
	}
	public void setFil(String fil) 
	{
		this.filiere = fil;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	//toString
	public String toString()
	{
		return (id + " - l'etudiant " + nom + " " + prenom + " du filiere : " + filiere + " ,cin: " + CIN);
	}
	
	public static void show_all_etud(Etudiant[] tab) 
	{
		for (Etudiant var : tab) 
		{
			System.out.println(var);
		}
	}
	public static Etudiant search_by_id(Etudiant[] l, int id) 
	{
		for (int i = 0;i < l.length; i++) 
		{
			if (l[i].getId() == id)
			{
				return l[i];
			}
		}
		return null;
	}
	
	public String tocsv()
	{
		return (id + "," + nom + "," + prenom + "," + CIN + "," + filiere + "\n");
	}
}
