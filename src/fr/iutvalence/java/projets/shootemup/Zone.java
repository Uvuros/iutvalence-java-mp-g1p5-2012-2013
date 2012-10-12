package fr.iutvalence.java.projets.shootemup;

/**
 * @author Deguitre & Pignet
 * Gestion de la zone de jeux 
 */
public class Zone
{
	/**
	 * Case sans vaisseau
	 */
	public final static int VIDE = 0;
	/**
	 * Taille max de la zone de jeux
	 */
	public static final int MAX = 100;
	/**
	 * Tableaux à deux dimensions représentant la zone de jeux
	 */
	private int[][] zone;
	/**
	 * Taille de la zone de jeux
	 */
	public int taille;
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
		this.taille = MAX;
	}
	/**
	 * @param choix taille de la zone de jeux
	 */
	public Zone(int choix)
	{
		this.taille = choix;
		this.zone = new int[this.taille][this.taille];
		for(int x = 0; x < this.taille; x++)
		{
			for(int y = 0; y < this.taille; y++)
			{
				this.zone[x][y] = VIDE;
			}
		}
	}
	/**
	 * met la valeur Valeur dans zone[x][y]
	 * @param x emplacement sur l'axe x
	 * @param y emplacement sur l'axe y
	 * @param Valeur Valeur à ajouter <tt>VIDE</tt>, <tt>ENNEMI</tt> ou <tt>VAISSEAU</tt>
	 */
	public void modification(int x,int y, int Valeur)
	{		
		this.zone[y][x] = Valeur;	
	}
	
	/**
	 * Affiche le contenu d'une case de la zone de jeux
	 * @param x emplacement sur l'axe x
	 * @param y emplacement sur l'axe y
	 * @return contenu de la case ciblée
	 */
	public int contenu(int x,int y)
	{
		return this.zone[y][x];
	}
	/**
	 * Fonction de défilement de la zone de jeux
	 * @return -1 si collision 1 sinon
	 */
	public int scroll()
	{							// Scroll depuis le bas vers le haut de la zone
		int collision = 1;
		int indice_ligne = this.taille-1;
		int indice_colone = 0;
		while (indice_ligne > 0) // tant qu'on as pas atteint la derniére ligne de la zone de jeux
		{
			if (indice_colone == this.taille)
			{					// Si on as atteint la derniére colone de la ligne => ligne suivante / retourner au début de colone
				indice_ligne--;
				indice_colone = 0;
			}
			if (this.zone[indice_ligne][indice_colone] != 1)
			{					// Si l'élément est différent du vaisseau joueur
				if (indice_ligne-1 < 0)
				{				// Si l'on est sur la derniére ligne => créer une nouvelle ligne (ligne vide)
					this.zone[indice_ligne][indice_colone]=0;
				}
				else
				{	if(this.zone[indice_ligne-1][indice_colone] != 1)		
					{			// Si l'élément du dessus n'est pas le vaisseau joueur on copie la ligne du dessus
						this.zone[indice_ligne][indice_colone]=this.zone[indice_ligne-1][indice_colone];
						this.zone[indice_ligne-1][indice_colone]=0;
					}			
					else
					{			// Sinon on remplace par 0 (le vaisseau joueur n'est pas affecetr par le scroll)
						this.zone[indice_ligne][indice_colone]=0;
					}
				}
			}
			else
			{
				if(this.zone[indice_ligne-1][indice_colone] == 2)
				{				// Si l'élément au dessus du vaisseau est un ennemi => collision
					collision = -1;
				}				
			}
			indice_colone = indice_colone+1;
			
			
		}
		return collision;
		
	}
	public String toString()
	{
		String result="";
		// ...
		for (int x = 0; x < this.taille; x++) 
	    { 
		  for (int y = 0; y < this.taille; y++) 
		  { 
			  switch(this.zone[x][y])
		        {
		            case 0:
		            	result = result + " ";
		            break;
		            case 2:		// ennemi représentés par |
		                result = result + "|";
		            break;
		            case 1:		// Vaisseau joueur représenté par A
		            	result = result + "A";
		            break;
		            default: result = result + "?";
		        }

		  }
		  result = result + "\r\n";
		}
		result+="-------------------------";
		return result;
	}
}
