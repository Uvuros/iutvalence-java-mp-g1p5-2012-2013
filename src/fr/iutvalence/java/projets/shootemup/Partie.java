package fr.iutvalence.java.projets.shootemup;

/**
 * Classe partie
 * @author Deguitre & Pignet
 *
 */
public class Partie
{
	/**
	 * Valeur représentant la mort du joueur  
	 */
	public static final int MORT = -1;
	/**
	 * Valeur indiquant que le joueur est en vie
	 */
	public static final int VIVANT = 1;
	
	/**
	 * Case sans vaisseau
	 */
	public final static int VIDE = 0;
	/**
	 * Case avec un vaisseau ennemi
	 */
	public final static int VAISSEAU = 1;
	/**
	 * Case avec le vaisseau joueur
	 */
	public final static int ENNEMI = 2;
	/**
	 * Représente le score du joueur
	 */
	public int score;
	/**
	 * Tableaux à deux dimensions représentant la zone de jeux
	 */
	public Zone zone;
	/**
	 * Représente le nombre de vie du joueur
	 */
	public int vie;
	/**
	 * Pseudo du joueur
	 */
	public String pseudo;
	
	
	/**
	 * Initialise une partie
	 * @param pseudo du joueur souhaiter
	 */
	public Partie(String pseudo)
	{
		this.score = 0;
		this.vie = 3;
		this.pseudo = pseudo;		
		Ship joueur = new Ship(); 
		Zone zone = new Zone();
		this.zone = zone;
		zone.zone[joueur.coord_x][joueur.coord_y] = joueur.type_ship;
	}
	
	/**
	 * Fonction permettant d'enlever une vie
	 * @param joueur vaisseau du joueur
	 * @return renvois <tt>VIVANT</tt> s'il reste des vie à l'utilisateur sinon <tt>MORT</tt> et détruit le vaisseaux du joueur
	 */
	public int Vie_moins(Ship joueur)
	{
		if (this.vie != 0)
		{
			this.vie = this.vie -1;
			if (this.vie == 0)
			{
				joueur.detruire();
				return MORT;
			}
			else
			{
			return VIVANT;
			}
		}
		else
		{
			joueur.detruire();
			return MORT;
		}
	}
	/**
	 * Ajout de points
	 * @param points Nombre de points à ajouter
	 */
	public void Ajout_points()
	{
		this.score = this.score + 100;
	}
	
	/**
	 * Débuter une partie  
	 */
	public void start(Zone terrain) 
	{
		Ship ennemi = new Ship(50,60,terrain);
		terrain.modification(50,60,2);
		while (this.vie != 2)
		{	
			int i = 0;
			while (i < 99)
			{
			  int j = 0;
			  while(j < 99)
			  {
			    System.out.print(terrain.zone[i][j]);
			    j++;
			  }
			  System.out.print("\n");
			  i++;
			}
			ennemi.deplacement(0,-10, terrain);
			
		}
	}
	
}
