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
	 * Vaisseau joueur
	 */
	public Ship joueur;
	/**
	 * Représente le score du joueur
	 */
	public int score;
	/**
	 * variable de type zone initialiser lors de la creation d'une partie
	 */
	public Zone zone;
	
	/**
	 * Représente le nombre de vie du joueur
	 */
	public int vies;
	/**
	 * Liste des ships créer
	 */
	public Ship[] liste;
	/**
	 * Pseudo du joueur
	 */
	public String pseudo;
	/**
	 * Initialisation d'une partie met le score à 0, le nombre de vies à 3, crée un vaisseau joueur et la zone de jeux.
	 * @param pseudo du joueur souhaiter
	 */
	public Partie(String pseudo)
	{
		this.score = 0;
		this.vies = 3;
		this.pseudo = pseudo;		
		Ship joueur = new Ship(); 
		this.joueur=joueur;
		Zone zone = new Zone(8);
		this.zone = zone;
		zone.modification(joueur.position.x,joueur.position.y,joueur.type_ship);
		this.liste = new Ship[100];
	}
	/**
	 * Fonction permettant d'enlever une vie et retourne l'état du joueur(1 en vie / -1 mort)
	 * @param joueur vaisseau du joueur
	 * @return renvois <tt>VIVANT</tt> s'il reste des vie à l'utilisateur sinon <tt>MORT</tt> et détruit le vaisseaux du joueur
	 */
	public int vieMoins()
	{
		if (this.vies != 0)
		{
			this.vies = this.vies -1;
			if (this.vies == 0)
			{
				this.joueur.detruire();
			}
		}
		return this.joueur.etat;

	}
	/**
	 * Ajout de points
	 * @param points Nombre de points à ajouter
	 */
	public void ajoutPoints()
	{
		this.score = this.score + 100;
	}
	
	/**
	 * permet d'effectuer une pause
	 * @param delai nombre de milliseconde à attendre
	 */
	public void pause(long delai)  
	{
		long t=System.currentTimeMillis();
		while( (System.currentTimeMillis()-t)<delai)
		{
			
		}
	}
	/**
	 * Débuter une partie  
	 */
	public void start()   
	{	
		Affichage affichage = new Affichage(this.zone);
		int i = 0;
		while (this.vies != 0)
		{	
			if (i == 0)
			{
				this.zone.modification(1,(int)( Math.random()*( (this.zone.taille-1) + 1 ) ) + 0,2);
				i = 1;
			}
			else
				i =0;
			// Déplacement => gestion collision
			// Scroll => gestion collision
		    int x = this.zone.scroll();
		    if (x ==-1)
			{
				this.vieMoins();
			}
		    affichage.afficher();
			pause(250);
		}
	}
	
}
