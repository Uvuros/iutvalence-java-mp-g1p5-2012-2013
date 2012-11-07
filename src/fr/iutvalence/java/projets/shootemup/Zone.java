package fr.iutvalence.java.projets.shootemup;

/**
 * Gestion de la zone de jeu
 * 
 * @author Deguitre & Pignet
 * 
 */
public class Zone
{
	/**
	 * Booleén renvoyé lorsqu'il n'y as pas de collision
	 */
	public final static boolean NON_COLLISION = false;
	/**
	 * Booleén renvoyé lors d'une collision
	 */
	public final static boolean COLLISION = true;

	/**
	 * Taille max de la zone de jeux
	 */
	public static final int MAX = 100;

	
	
	
	/**
	 * Tableaux à deux dimensions représentant la zone de jeux (contenu des case = [VIDE,ENNEMi,JOUEUR]
	 */
	private ContenuZone[][] zone;

	/**
	 * Taille de la zone de jeu
	 */
	private final int taille;

	/**
	 * Création de la zone de jeux de taille <tt>MAX</tt>, initialisation de toute les cases à <tt>VIDE</tt>
	 */
	public Zone()
	{
		this.zone = new ContenuZone[MAX][MAX];
		for (int x = 0; x < MAX; x++)
		{
			for (int y = 0; y < MAX; y++)
			{
				this.zone[x][y] = ContenuZone.VIDE;
			}
		}
		this.taille = MAX;
	}

	/**
	 * Création de la zone de jeux et initialise toute les cases à <tt>VIDE</tt
	 * 
	 * @param taille
	 *            taille de la zone de jeux
	 */
	public Zone(int taille)
	{
		this.taille = taille;
		this.zone = new ContenuZone[this.taille][this.taille];
		for (int x = 0; x < this.taille; x++)
		{
			for (int y = 0; y < this.taille; y++)
			{
				this.zone[x][y] = ContenuZone.VIDE;
			}
		}
	}

	/**
	 * Fonction qui permet d'obtenir la taille de la zone de jeux
	 * 
	 * @return renvoie la taille de la zone de jeux
	 */
	public int getTaille()
	{
		return this.taille;
	}

	/**
	 * met la valeur Valeur dans zone[x][y]
	 * 
	 * @param x
	 *            emplacement sur l'axe x
	 * @param y
	 *            emplacement sur l'axe y
	 * @param valeur
	 *            Valeur à ajouter <tt>VIDE</tt>, <tt>ENNEMI</tt> ou <tt>VAISSEAU</tt>
	 */
	public void modification(int x, int y, ContenuZone valeur)
	{
		this.zone[y][x] = valeur;
	}

	/**
	 * Renvoie le contenu d'une case de la zone de jeux
	 * 
	 * @param x
	 *            emplacement sur l'axe x
	 * @param y
	 *            emplacement sur l'axe y
	 * @return contenu de la case ciblée
	 * @throws HorsZoneException
	 *             lorsque x ou y est en dehors de la zone de jeux
	 */
	public ContenuZone contenu(int x, int y) throws HorsZoneException
	{
		if ((x > this.taille) || (x < 0) || (y > this.taille) || (y < 0))
			throw new HorsZoneException();
		return this.zone[y][x];
	}

	
	/**
	 * Fonction de défilement de la zone de jeu
	 * 
	 * @return <tt>COLLISION</tt> s'il y a eu une collision lors du scroll sinon <tt>NON_COLLISION</tt>
	 */
	public boolean scroll()
	{							// Scroll depuis le bas vers le haut de la zone
		boolean collision = NON_COLLISION;
		int indice_ligne = this.taille - 1;
		int indice_colone = 0;
		while (indice_ligne > 0) // tant qu'on as pas atteint la derniére ligne de la zone de jeux
		{
			if (indice_colone == this.taille)
			{					// Si on as atteint la derniére colone de la ligne => ligne suivante / retourner au début de colone
				indice_ligne--;
				indice_colone = 0;
			}
			if (this.zone[indice_ligne][indice_colone] != ContenuZone.JOUEUR)
			{					// Si l'élément est différent du vaisseau joueur
				if (indice_ligne - 1 < 0)
				{				// Si l'on est sur la derniére ligne => créer une nouvelle ligne (ligne vide)
					this.zone[indice_ligne][indice_colone] = ContenuZone.VIDE;
				}
				else
				{
					if (this.zone[indice_ligne - 1][indice_colone] != ContenuZone.JOUEUR)
					{			// Si l'élément du dessus n'est pas le vaisseau joueur on copie la ligne du dessus
						this.zone[indice_ligne][indice_colone] = this.zone[indice_ligne - 1][indice_colone];
						this.zone[indice_ligne - 1][indice_colone] = ContenuZone.VIDE;
					}
					else
					{			// Sinon on remplace par 0 (le vaisseau joueur n'est pas affecetr par le scroll)
						this.zone[indice_ligne][indice_colone] = ContenuZone.VIDE;
					}
				}
			}
			else
			{
				if (this.zone[indice_ligne - 1][indice_colone] == ContenuZone.ENNEMI)
				{				// Si l'élément au dessus du vaisseau est un ennemi => collision
					collision = COLLISION;
				}
			}
			indice_colone = indice_colone + 1;

		}
		return collision;

	}

	/**
	 * renvoie le tableaux à deux dimenssions
	 * 
	 * @return tableaux à deux dimenssions
	 */
	public ContenuZone[][] getZone()
	{
		return this.zone;
	}

	/**
	 * Affichage de type :
	 *    |   
	 *       
	 *      |
	 *      
	 *     |  
	 *       A
	 *  ------------    
	 *  retourne une chaine composé de chaque ligne suivi d'un 
	 *  retour chariot en commençant par le haut de la zone
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String result = "";
		// ...
		for (int x = 0; x < this.taille; x++)
		{
			for (int y = 0; y < this.taille; y++)
			{
				switch (this.zone[x][y])
				{
					case VIDE:
						result = result + " ";
						break;
					case ENNEMI:		// ennemi représentés par |
						result = result + "|";
						break;
					case JOUEUR:		// Vaisseau joueur représenté par A
						result = result + "A";
						break;
					default:
						result = result + "?";
				}

			}
			result = result + "\r\n";
		}
		result += "-------------------------";
		return result;
	}
}
