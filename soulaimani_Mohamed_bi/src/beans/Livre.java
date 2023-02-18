package beans;

public class Livre {
	String	titre;
	int		edit;
	int		date;
	int		stock;
	int		id;
		
	//Constructor
	public Livre() 
	{
		titre = "default";
		edit = 2020;
		date = 2021;
		stock = 0;
	}
	public Livre(int id, String titre, int edit, int date, int stock) 
	{
		this.id = id;
		this.titre = titre;
		this.edit = edit;
		this.date = date;
		this.stock = stock;
	}
			
	//getters
	public String getTitre() 
	{
		return (titre);
	}
	public int getEdit() 
	{
		return (edit);
	}
	public int getDate() 
	{
		return (date);
	}
	public int getStock() 
	{
		return (stock);
	}
	public int getId() 
	{
		return (id);
	}
	
	//setters
	public void setTitre(String name) 
	{
		this.titre = name;
	}
	public void setId(int name) 
	{
		this.id = name;
	}
	public void setDate(int a) 
	{
		this.date = a;
	}
	public void setStock(int a) 
	{
		this.stock = a;
	}
	public void setEdit(int a) 
	{
		this.edit = a;
	}
	
	//to String
	public String toString()
	{
		return (id + " - le livre " + titre + ", editer le: " + edit + ", apparue le: " + date + ", " + stock + " dans le stock");
	}
	
	public String tocsv()
	{
		return (id + "," + titre + "," + edit + "," + date + "," + stock + "\n");
	}
	
	public static void show_all_books(Livre[] tab) 
	{
		for (Livre var : tab) 
		{
			System.out.println(var);
		}
	}
	
	public static Livre search_by_id(Livre[] l, int id) 
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
	
}
