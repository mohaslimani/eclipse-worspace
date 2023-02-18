import beans.*;
import dao.*;
import view.*;


public class Application {

	public static void main(String[] args)
	{
		while_boucle1:
		while (true)
		{
			int choix = Menu.principal();
			
			switch (choix)
			{
				case 1:
				{
					while_livre:
					while (true)
					{
						int choixL = Menu.livre();
						System.out.println("En train de gérer les livres");
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
							}; break;
							case 4:
							{
								System.out.println("-	Modifier un livre oo");
								Livre.show_all_books(list);
								int id = Menu.newintscan("selectionner l id d un livre a modifie");
								
								//DaoGeneral.delete_by_id("livre", id);
								int choixML = Menu.modif_livre();
								if (choixML == 1) 
								{
									String titre = Menu.newStringscan("give me the new title :");
									DaoGeneral.update_by_id("livre", "titre", id, titre);
								}
								else if (choixML >= 2 && choix <= 3) 
								{
									int neww;
									if (choixML == 2)	
										neww = Menu.newintscan("l edit :");
									else if (choixML == 2)
										neww = Menu.newintscan("the date :");
									else if (choixML == 2)
										neww = Menu.newintscan("the stock :");
								}
								
								//Livre l = new Livre(0 ,titre, edit, date, stock);
								//LivreDao.add_Livre_database(l);
							}; break;
							case 5:
							{
								System.out.println("-	Supprimer un livre");
								Livre.show_all_books(list);
								int id = Menu.newintscan("selectionner l id d un livre a supp :");
								DaoGeneral.delete_by_id("livre", id);
							}; break;
							case 0:
							{
								System.out.println("En train de quitter ... ");
								break while_livre;
							}
						}
					}
				}; break;
				case 2:
				{
					while_etud:
					while (true)
					{
						int choixe = Menu.etud();
						System.out.println("En train de gérer les etudiant");
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
							case 4:
							{
								System.out.println("-	Modifier un etud");
								Etudiant.show_all_etud(list);
								int id = Menu.newintscan("selectionner l id d etudiant a modifie");
								DaoGeneral.delete_by_id("Etudiant", id);
								String nom = Menu.newStringscan("le nom :");
								String prenom = Menu.newStringscan("prenom :");
								String cin = Menu.newStringscan("cin :");
								String fil = Menu.newStringscan("fil :");
								Etudiant l = new Etudiant(0 ,nom, prenom, fil, cin);
								EtudiantDao.add_etud_database(l);
							}; break;
							case 5:
							{
								System.out.println("5-	Supprimer un livre");
								Etudiant.show_all_etud(list);
								int id = Menu.newintscan("selectionner l id d un Etudiant a supp :");
								DaoGeneral.delete_by_id("Etudiant", id);
							}; break;
							case 0:
							{
								System.out.println("En train de quitter ... ");
								break while_etud;
							}
						}
					}
				}; break;
				case 3:
				{
					EmpruntDao.Create_database();
					System.out.println("-- emprunter un livre");
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
						System.out.println(le.length);
						if (le.length <= 3)
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
					Menu.contin();
				}; break;
				case 4:
				{
					System.out.println("-- Remettre un livre");
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
						EmpruntDao.delete_first_by_id(idE, idL);
						LivreDao.update_stock(1 + Livre.search_by_id(le, idL).getStock() , idL);
						Menu.contin();
					}
					else
					{
						System.out.println("l etudiant n a emprunter aucun livre");
					}
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
}
		/*Etudiant pp = new Etudiant();
		Etudiant cc = new Etudiant("moha", "sli", "grt", "t244");
		
		System.out.println(cc);
		System.out.println(pp);
		
		Livre uu = new Livre("anal", 1025, 2012, 5);
		System.out.println(uu);
		LivreDao.Create_Livre_database();
		DaoGeneral.delete_all_table("Livre");
		LivreDao.add_Livre_database(uu);
		Livre[] tab = new Livre[2];
		tab[0] = new Livre();
		tab[1] = uu;
		LivreDao.add_Livres_table(tab);
		tab = LivreDao.select_all();
		Livre.show_all_books(tab);*/
		
