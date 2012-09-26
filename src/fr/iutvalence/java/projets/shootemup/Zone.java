package fr.iutvalence.java.projets.shootemup;

// FIXME écrire un commentaire correct, préciser le repère
/**
 * @author Deguitre & Pignet
 * Zone de jeux
 */
public class Zone
{
	/**
	 * Case sans vaisseau
	 */
	public final static int VIDE = 0;
	
	//FIXME inutile, gérer les erreurs avec des exceptions
	/**
	 * Valeur représentant l'exécution normal de la fonction
	 */
	public static final int REUSSITE = 1;
	
	/**
	 * Valeur renvoyée lorsque la case est pleine 
	 */
	public static final int PLEIN = -1;
	
	
	/**
	 * Taille max de la zone de jeux
	 */
	public static final int MAX = 100;
	
	// FIXME attribut à déclarer en privé
	/**
	 * Tableaux à deux dimensions représentant la zone de jeux
	 */
	public int[][] zone;
	
	//FIXME prévoir un autre constructeur où on peut spécifier la taille de la zone
	/**
	 * Création de la zone de jeux et initialise toute les cases à <tt>VIDE</tt>
	 */
	public Zone()
	{
		this.zone = new int[MAX][MAX];
		for(int x = 0; x < MAX; x++)
		{
			for(int y = 0; y < MAX; y++)
			{
				this.zone[x][y] = VIDE;
			}
		}
	}
	/**
	 * @param x emplacement sur l'axe x
	 * @param y emplacement sur l'axe y
	 * @param Valeur Valeur à ajouter <tt>VIDE</tt>, <tt>ENNEMI</tt> ou <tt>VAISSEAU</tt>
	 * @return <tt>REUSSITE</tt> si la case était vide <tt>PLEIN</tt> sinon
	 */
	public int modification(int x,int y, int Valeur)
	{		
		//FIXME en quoi la modification d'une case de la zone peut ne pas être possible .
		if (this.zone[x][y] != 0)
		{
			if(Valeur != 0)
			{
				return PLEIN;
			}
			else
			{
				this.zone[x][y] = Valeur;
				return REUSSITE;
			}
		}
		else
		{
			this.zone[x][y] = Valeur;
			return REUSSITE;
		}
	}
	
	/**
	 * Affiche le contenu d'une case de la zone de jeux
	 * @param x emplacement sur l'axe x
	 * @param y emplacement sur l'axe y
	 * @return contenu de la case ciblée
	 */
	public int contenu(int x,int y)
	{
		return this.zone[x][y];
	}
}
