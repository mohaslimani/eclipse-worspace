package soulaimani_Mohamed_bi;

import view.Menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import beans.*;
import dao.*;

import files.*;

public class Application {

	public static void main(String[] args) {
		
		while_boucle1:
		while (true)
		{
			int choix = Menu.principal();
			switch (choix)
			{
				case 1:
				{
					System.out.println("#########   Gerer les livres   #######");
					gerer_les_livre();
					Menu.contin();
				}; break;
				case 2:
				{
					System.out.println("#########   Gerer les etudiants   #######");
					gerer_les_etudiant();
					Menu.contin();
				}; break;
				case 3:
				{
					System.out.println("#########   Emprunter un livre    #######");
					emprunter_un_livre();
					Menu.contin();
				}; break;
				case 4:
				{
					System.out.println("#########   Remettre un livre   #######");
					remettre();
					Menu.contin();
				}; break;
				case 5:
				{
					System.out.println("#########   Enregistrer les donnes dans des fichiers CSV    #######");
					csv();
					Menu.contin();
				}; break;
				case 0:
				{
					System.out.println("En train de quitter ... ");
					break while_boucle1;
				}
			}
		}
	}
	
	public static void gerer_les_livre()
	{
		while_livre:
		while (true)
		{
			int choixL = Menu.livre();
			LivreDao.Create_Livre_database();
			Livre[] list = LivreDao.select_all();
			switch (choixL)
			{
				case 1:
				{
					System.out.println("-	Lister les livres");
					Livre.show_all_books(list);
					Menu.contin();
				}; break;
				case 2:
				{
					System.out.println("-	Alimenter le stock d’un livre");
					Livre.show_all_books(list);
					int id = Menu.newintscan("selectionner l id d un livre a alimenter");
					int st = Menu.newintscan("vous voulez alimenter par ?");
					LivreDao.update_stock(st + Livre.search_by_id(list, id).getStock() , id);
					System.out.println("the new data");
					System.out.println(LivreDao.select_one(id));
					Menu.contin();
				}; break;
				case 3:
				{
					System.out.println("-	Ajouter un livre");
					String titre = Menu.newStringscan("give me the title :");
					int		edit = Menu.newintscan("l edit :");
					int		date = Menu.newintscan("the date :");
					int		stock = Menu.newintscan("the stock :");
					Livre l = new Livre(0 ,titre, edit, date, stock);
					LivreDao.add_Livre_database(l);
					Menu.contin();
				}; break;
				case 4:
				{
					System.out.println("-	Modifier un livre");
					Livre.show_all_books(list);
					int id = Menu.newintscan("selectionner l id d un livre a modifie");
					int choixML = Menu.modif_livre();
					if (choixML == 1) 
					{
						String titre = Menu.newStringscan("give me the new title :");
						DaoGeneral.update_by_id("livre", "titre", id, titre);
					}
					else if (choixML == 2)
						DaoGeneral.update_by_id("livre", "edit", id, Integer.toString(Menu.newintscan("l edit :")));
					else if (choixML == 3)
						DaoGeneral.update_by_id("livre", "date", id, Integer.toString(Menu.newintscan("the date :")));
					else if (choixML == 4)
						DaoGeneral.update_by_id("livre", "stock", id, Integer.toString(Menu.newintscan("the stock :")));
					Menu.contin();
				}; break;
				case 5:
				{
					System.out.println("-	Supprimer un livre");
					Livre.show_all_books(list);
					int id = Menu.newintscan("selectionner l id d un livre a supp :");
					DaoGeneral.delete_by_id("livre", id);
					Menu.contin();
				}; break;
				case 0:
				{
					System.out.println("return ... ");
					break while_livre;
				}
			}
		}
	}
	
	public static void gerer_les_etudiant()
	{
		while_etud:
		while (true)
		{
			int choixe = Menu.etud();
			System.out.println("En train de gerer les etudiant");
			EtudiantDao.Create_etud_database();
			Etudiant[] list = EtudiantDao.select_all();
			switch (choixe)
			{
				case 1:
				{
					System.out.println("-	Lister");
					Etudiant.show_all_etud(list);
					Menu.contin();
				}; break;
				case 2:
				{
					System.out.println("-	Ajouter ");
					String nom = Menu.newStringscan("le nom :");
					String prenom = Menu.newStringscan("prenom :");
					String cin = Menu.newStringscan("cin :");
					String fil = Menu.newStringscan("fil :");
					Etudiant l = new Etudiant(0 ,nom, prenom, fil, cin);
					EtudiantDao.add_etud_database(l);
				}; break;
				case 3:
				{
					System.out.println("-	Modifier un etud");
					Etudiant.show_all_etud(list);
					int id = Menu.newintscan("selectionner l id d etudiant a modifie");
					int choixME = Menu.modif_etud();
					if (choixME == 1) 
					{
						String nom = Menu.newStringscan("nouveau nom :");
						DaoGeneral.update_by_id("etudiant", "nom", id, nom);
					}
					else if (choixME == 2)
						DaoGeneral.update_by_id("etudiant", "prenom", id, Menu.newStringscan("nouveau prenom  :"));
					else if (choixME == 3)
						DaoGeneral.update_by_id("etudiant", "fil", id, Menu.newStringscan("nouveau filiere"));
					else if (choixME == 4)
						DaoGeneral.update_by_id("etudiant", "cin", id, Menu.newStringscan("nouveau CIN :"));
					Menu.contin();
				}; break;
				case 4:
				{
					System.out.println("5-	Supprimer un livre");
					Etudiant.show_all_etud(list);
					int id = Menu.newintscan("selectionner l id d un Etudiant a supp :");
					DaoGeneral.delete_by_id("Etudiant", id);
					Menu.contin();
				}; break;
				case 0:
				{
					System.out.println("En train de quitter ... ");
					break while_etud;
				}
			}
		}
	}
	public static void emprunter_un_livre()
	{
		EmpruntDao.Create_database();
		Livre[] listL = LivreDao.select_all();
		Livre.show_all_books(listL);
		int idL = Menu.newintscan("selectionner l id d un livre :");
		Etudiant[] listE = EtudiantDao.select_all();
		Etudiant.show_all_etud(listE);
		int idE = Menu.newintscan("selectionner l id d un Etudiant :");
		int date = Menu.newintscan("la date :");
		Emprunt em = new Emprunt(idE, idL, date);
		if (Livre.search_by_id(listL, idL).getStock() > 0)
		{
			Livre[] le = EmpruntDao.Q_livre_par_etudiant(idE);
			if (le.length < 3)
			{							
				EmpruntDao.add_database(em);
				System.out.println(em);
				LivreDao.update_stock(Livre.search_by_id(listL, idL).getStock() - 1, idL);
				System.out.println("sucess");
			}
			else 
			{
				System.out.println("l'etudiant :" + Etudiant.search_by_id(listE, idE) + "a emprunter plus de 3 livre");
				System.out.println("list des livre :");
				Livre.show_all_books(le);
				System.out.println("failed");
			}
		}
		else
			System.out.println("le stock de ce livre est null");
	}
	public static void remettre()
	{
		Etudiant[] listE = EtudiantDao.select_all();
		Etudiant.show_all_etud(listE);
		int idE = Menu.newintscan("selectionner l id d un Etudiant :");
		Livre[] le = EmpruntDao.Q_livre_par_etudiant(idE);
		if (le.length > 0)
		{
			System.out.println("l'etudiant :" + Etudiant.search_by_id(listE, idE) + "a emprunter :");
			System.out.println("list des livre :");
			Livre.show_all_books(le);
			int idL = Menu.newintscan("selectionner l id de livre a remettre :");
			EmpruntDao.update_first_by_id(idE, idL);
			LivreDao.update_stock(1 + Livre.search_by_id(le, idL).getStock() , idL);
			Menu.contin();
		}
		else
		{
			System.out.println("l etudiant n a emprunter aucun livre");
		}
	}
	public static void csv()
	{
		try {
			Etudiant[] listE = EtudiantDao.select_all();
			Livre[] listL = LivreDao.select_all();
			Emprunt[] listEm = EmpruntDao.select_all();
			String dir = "C:\\Users\\soulaimani\\eclipse-workspace\\soulaimani_Mohamed_bi\\export\\";
			int ch = Menu.newintscan("voulez vous l'exporter dans un autre dossier ? 1 pour oui");
			if (ch == 1)
				dir = Menu.newStringscan("entrer la directory");
			String name = dir + "Etudiant.csv";
			FileWriter fw = new FileWriter(name,false);
			fw.write("Etudiant \nid,nom,prenom,CIN,filiere\n");
			for (Etudiant var : listE)
			{
				fw.write(var.tocsv());
			}
		    fw.close();
		    name = dir + "Livre.csv";
			FileWriter fw1 = new FileWriter(name,false);
			fw1.write("Livre \nid,titre,date d edition,date d apparu,stock\n");
			for (Livre var : listL)
			{
				fw1.write(var.tocsv());
			}
		    fw1.close();
		    name = dir + "Emprunt.csv";
			FileWriter fw2 = new FileWriter(name,false);
			fw2.write("Livre \nidEtudiant,idLivre,date,remise\n");
			for (Emprunt var : listEm)
			{
				fw2.write(var.tocsv());
			}
		    fw2.close();

	      }
	      catch (IOException e) {
	         System.out.println("exception files");
	      }
	}
}
