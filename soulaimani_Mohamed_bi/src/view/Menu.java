package view;

import java.util.Scanner;

public class Menu {

	private static Scanner sc;
	
	private static Scanner getScanner () {
		if(sc == null)
			sc = new Scanner(System.in);
		
		return sc;
	}
	
	public static int principal () {
		
		try {
		System.out.println("#########   MENU   #######");
		
		System.out.println("1: Gérer les livres");
		System.out.println("2: Gérer les étudiants");
		System.out.println("3: Emprunter un livre");
		System.out.println("4: Remettre un livre");
		System.out.println("5: Enregistrer les données dans des fichiers CSV");
		System.out.println("0: Quitter");
		
		System.out.println("Votre choix: ...");
		
		int choix = getScanner().nextInt();
		
		return choix;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	public static int modif_livre () {
		
		try {
		System.out.println("#########   MENU MOD LIVRE  #######");
		
		System.out.println("1: titre ");
		System.out.println("2: edition ");
		System.out.println("3: date ");
		System.out.println("4: stock ");
		System.out.println("0: anuller ");
		
		System.out.println("Votre choix: ...");
		
		int choix = getScanner().nextInt();
		
		return choix;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	public static int modif_etud () {
		
		try {
		System.out.println("#########   MENU MOD ETUDIANT  #######");
		
		System.out.println("1: nom ");
		System.out.println("2: prenom ");
		System.out.println("3: filiere ");
		System.out.println("4: cin ");
		System.out.println("0: anuller ");
		
		System.out.println("Votre choix: ...");
		
		int choix = getScanner().nextInt();
		
		return choix;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	public static int livre () {
		
	try {
		System.out.println("1-	Lister les livres");
		System.out.println("2-	Alimenter le stock d’un livre");
		System.out.println("3-	Ajouter un livre");
		System.out.println("4-	Modifier un livre");
		System.out.println("5-	Supprimer un livre");
		System.out.println("0-  RETURN");
	
		System.out.println("Votre choix: ...");
		
		int choix = getScanner().nextInt();
		
		return choix;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}

	public static int etud () {
		
	try {
		
		System.out.println("1-	Lister les etud");
		System.out.println("2-	Ajouter un etud");
		System.out.println("3-	Modifier un etud");
		System.out.println("4-	Supprimer un etud");
		System.out.println("0-  RETURN");
	
		System.out.println("Votre choix: ...");
		
		int choix = getScanner().nextInt();
		
		return choix;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	public static void contin () {
		try {
		sc = new Scanner(System.in);
		System.out.println("tab to continue");
		getScanner().nextLine();
		}
		catch(Exception e)
		{
			
		}
	}
	public static int newintscan (String comm) {
		try {
			sc = new Scanner(System.in);
			System.out.println(comm);
			return sc.nextInt();
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	public static String newStringscan (String comm) {
		try {
			sc = new Scanner(System.in);
			System.out.println(comm);
			return sc.nextLine();
		}
		catch(Exception e)
		{
			return null;
		}
	}
}