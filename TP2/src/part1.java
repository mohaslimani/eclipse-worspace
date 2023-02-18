import java.util.Random;
import java.util.Arrays;

final public class part1 {

	static int	maxTableau(int[] tab) 
	{
		int max = tab[0];
		for (int i = 1; i < tab.length ; i++) 
		{
			if (tab[i] > max) 
				max = tab[i];
		}
		return (max);
	}    

	static int getRandomInt(int min, int max){
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}
	
	static int[] RandTable(int max_size) 
	{
		int tab[];
		int size = getRandomInt(1, max_size);
		tab = new int [size];
		for (int i = 0; i < size ; i++) //foreach can't create or modify the array
		{
			tab [i] = getRandomInt(-300 , 300);
		}
		return tab;
	}
	
	static void TabToRand(int tab[]) 
	{
		for (int i = 0; i < tab.length ; i++) //foreach can't create or modify the array
		{
			tab [i] = getRandomInt(-300 , 300);
		}
	}
	
	static void afficheTableau(int[] tab) 
	{
		System.out.print("[");
		for (int n : tab)
			System.out.print(n + " ");
		System.out.println("]");
	}
	
	static void afficheTableauPos(int[] tab) 
	{
		System.out.print("[");
		for (int n : tab)
		{
			if (n >= 0)
				System.out.print(n + " ");
		}
		System.out.println("]");
	}
	
	static void initTab(int tab[]) 
	{
		for (int i = 0; i < tab.length ; i++)
		{
			tab [i] = -1;
		}
	}
	
	static	boolean ajouterElement(int[] tab, int val) 
	{
		for (int i = 0; i < tab.length ; i++)
		{
			if (tab[i] == -1)
			{
				tab [i] = val;
				return true;
			}
		}
		return false;
	}
	
	static void remplir(int[] tab, int val) 
	{
		initTab(tab);
		while (ajouterElement(tab, val) == true);
	}
	
	static	boolean testRemplir(int[] tab, int val) 
	{
		for (int i = 0; i < tab.length ; i++)
		{
			if (tab[i] != val)
			{
				return false;
			}
		}
		return true;
	}
	
	static	int rechercher(int[] tab, int val) 
	{
		for (int i = 0; i < tab.length ; i++)
		{
			if (tab[i] == val)
			{
				return i;
			}
		}
		return -1;
	}
	
	static	int[] rechercherTous(int[] tab, int val) 
	{
		int j = 0;
		int[] ret = new int [tab.length];
		initTab(ret);
		for (int i = 0; i < tab.length ; i++)
		{
			if (tab[i] == val)
			{
				ret[j] = tab[i];
				j++;
			}
		}
		return ret;
	}
	
	static int rechercherTableauTrie(int tab[]) 
	{
		return (tab[tab.length]);
	}
	
	static boolean est_croissant(int tab[]) 
	{
		for (int i = 0; i < tab.length ; i++)
		{
			if (tab[i] > tab[i + 1]) 
			{
				return false;
			}
		}
		return true;
	}
	
	static int supprimer(int[] tab, int val) 
	{
		int choix = rechercher(tab, val);
		if (choix != -1)
		{
			for (int i = choix; i < tab.length - 1; i++) {
				tab[i] = tab[i + 1];
			}
			//int i is just inside the for
			tab[tab.length - 1] = -1;
			return (choix);
		}
		return (-1);
	}
	
	static void supprimerTous(int[] tab, int val) 
	{
		while (supprimer(tab, val) != -1);
	}
	
	static void weirdfun()
	{
		int i = 0;
		int j = 0;
		while (i++ < 5 || j++ < 2) 
		{
			System.out.println(i + ", " + j);
		}
		System.out.println(i + ", " + j);
	}
	
	public static void main(String[] args) {
		
		//different ways to create an array
		int 	t1[]	= {1, 2, 3, 4, 5, 6};
		int[] 	t2		= {-1, -2, -3, -4, -5};
		int		t3[];
		t3 = new int [8];
		//u did not create the Class named part1 then u cannot use the methode in it
		//unless u declare them as STATIC and thats why we called all functions as static
		t2 = RandTable(10);// i think u cannot modify an array in a fucnction like that u need to return it
		TabToRand(t3); //u r dump u can change the value because its a reference passing, but u cannot change the length
		
		//initTab(t1);
		afficheTableau(t1);
		//ajouterElement(t1, 5);
		remplir(t1, 5);
		afficheTableauPos(t1) ;
		System.out.println(testRemplir(t1, 5));
		t3[0] = 100;
		t3[1] = 100;
		t3[3] = 100;
		t3[7] = 100;
		System.out.println(Arrays.toString(t3)); //import java.util.Arrays;
		System.out.println(rechercher(t3, 100));
		supprimerTous(t3, 100);
		System.out.println(Arrays.toString(t3));
		System.out.println(rechercher(t3, 100));
		System.out.println(maxTableau(t3));
		weirdfun();
		
	}

}
