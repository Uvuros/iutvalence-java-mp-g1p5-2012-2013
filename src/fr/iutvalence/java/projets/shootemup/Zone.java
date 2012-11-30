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
	 * @param p
	 *            position dans la zone que nous voulons modifier
	 * @param valeur
	 *            Valeur à ajouter <tt>VIDE</tt>, <tt>ENNEMI</tt> ou <tt>VAISSEAU</tt>
	 */
	public void modification(Position p,ContenuZone valeur)
	{
		this.zone[p.getY()][p.getX()] = valeur;
	}

	/**
	 * Renvoie le contenu d'une case de la zone de jeux
	 * 
	 * @param p
	 *            position dans la zone pour laquel nous voulons savoir le contenu
	 * @return contenu de la case ciblée
	 * @throws HorsZoneException
	 *             lorsque x ou y est en dehors de la zone de jeux
	 */
	public ContenuZone contenu(Position p) throws HorsZoneException
	{
		if ((p.getX() > this.taille) || (p.getX() < 0) || (p.getY() > this.taille) || (p.getY() < 0))
			throw new HorsZoneException();
		return this.zone[p.getY()][p.getX()];
	}

	/**
	 * Fonction de défilement de la zone de jeu
	 * 
	 * @return <tt>COLLISION</tt> s'il y a eu une collision lors du scroll sinon <tt>NON_COLLISION</tt>
	 */
	public boolean scroll()
	{		
		Position p;
		int i = 0;
		// Scroll depuis le bas vers le haut de la zone
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
			if (this.zone[indice_ligne][indice_colone] != ContenuZone.JOUEUR && this.zone[indice_ligne][indice_colone] != ContenuZone.MISSILE)
			{					// Si l'élément est différent du vaisseau joueur
				if (indice_ligne - 1 < 0)
				{				// Si l'on est sur la derniére ligne => créer une nouvelle ligne (ligne vide)
					this.zone[indice_ligne][indice_colone] = ContenuZone.VIDE;
				}
				else
				{
					if (this.zone[indice_ligne - 1][indice_colone] != ContenuZone.JOUEUR && this.zone[indice_ligne - 1][indice_colone] != ContenuZone.MISSILE)
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
				if(indice_ligne -1 >= 0)
				{
				if (this.zone[indice_ligne - 1][indice_colone] == ContenuZone.ENNEMI)
				{				// Si l'élément au dessus du vaisseau est un ennemi => collision
					if (this.zone[indice_ligne][indice_colone] == ContenuZone.JOUEUR)
					{
						collision = COLLISION;
					}
					else
					{
						// ajout points comment faire ?
						this.zone[indice_ligne][indice_colone] = ContenuZone.VIDE;
						this.zone[indice_ligne -1][indice_colone] = ContenuZone.VIDE;
					}
				}
				}
			}
			indice_colone = indice_colone + 1;

		}
		/*
		 * int i = 0; if (i == 0) { this.zone.modification(new Position((int) (Math.random() * ((this.zone.getTaille() -
		 * 1) + 1)) + 0, 0), ContenuZone.ENNEMI); i = 1; } else { i = 0; }
		 */
		if (i == 0)
		{
			try
			{
				if (this.contenu( p = new Position((int) (Math.random() * ((this.getTaille() - 1) + 1)) + 0, 0)) == ContenuZone.JOUEUR)
				{
					collision = COLLISION;
				}
				else
				{
					this.modification(p,ContenuZone.ENNEMI);
				}
			}
			catch (HorsZoneException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		i = 1;
		}
		else
		{
			i = 0;
		}
		return collision;

	}

	/**
	 * test une position pour savoir si elel est dans la zone
	 * 
	 * @param p
	 *            position a tester
	 * @return vrai si la position est dans la zone faux sinon
	 */
	public boolean estDansZone(Position p)
	{
		return ((p.getX() > -1) && (p.getX() < this.taille) && (p.getY() > -1) && (p.getY() < this.taille));
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
	 * Affichage de type : |
	 * 
	 * |
	 * 
	 * | A ------------ retourne une chaine composé de chaque ligne suivi d'un retour chariot en commençant par le haut
	 * de la zone
	 * 
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
