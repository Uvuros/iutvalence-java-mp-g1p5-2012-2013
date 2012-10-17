package fr.iutvalence.java.projets.shootemup;

/**
 * Classe partie
 * @author Deguitre & Pignet
 *
 */
public class Partie
{
	/**
	 * Taille par défaut de la zone de jeux
	 */
	public static final int TAILLEZONE = 8;
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
	public Ship shipJoueur;
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
	 * Joueur (control de la partie) soit de type aléatoire soit de type clavier
	 */
	private Joueur joueur;
	/*/**
	 * Liste des ships créer		A utiliser quand nous utiliserons des objets ship ennemi
	 */
	//public Ship[] liste;
	/**
	 * Pseudo du joueur
	 */
	public String pseudo;
	/**
	 * Initialisation d'une partie met le score à 0, le nombre de vies à 5, crée un vaisseau joueur et la zone de jeux.
	 * @param pseudo du joueur souhaiter
	 * @param joueur interface permettant de controler la partie
	 */
	public Partie(String pseudo,Joueur joueur)
	{
		this.joueur = joueur;
		this.score = 0;
		this.vies = 5;
		this.pseudo = pseudo;		
		Ship player = new Ship(TAILLEZONE); 
		this.shipJoueur=player;
		Zone zone = new Zone(TAILLEZONE);
		this.zone = zone;
		zone.modification(player.getPosition().getX(),player.getPosition().getY(),player.typeShip);
		//this.liste = new Ship[100];
	}
	/**
	 * Fonction permettant d'enlever une vie et retourne l'état du joueur(1 en vie / -1 mort)
	 * @param shipJoueur vaisseau du joueur
	 * @return renvois <tt>VIVANT</tt> s'il reste des vie à l'utilisateur sinon <tt>MORT</tt> et détruit le vaisseaux du joueur
	 */
	public boolean vieMoins()
	{
		if (this.vies != 0)
		{
			this.vies = this.vies -1;
			if (this.vies == 0)
			{
				this.shipJoueur.detruire();
			}
		}
		return this.shipJoueur.etat;

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
	 * déplace le ship joueur
	 * @param move représente la direction dans laquel veut aller le joueur
	 */
	private void deplacement(int move)
	{
		int deplacement;
		switch(move)			// Uniquement deux posssibilité de mouvements pour l'instant 
        {						// Deplacement en x de 1 ou -1
            case 0:
            	deplacement = 0;
            break;
            case 1:
                deplacement = -1;
            break;
            case 2:
            	deplacement = 1;
            break;
            default: deplacement = 0;
        }
		int posX = this.shipJoueur.getPosition().getX();
		int posY = this.shipJoueur.getPosition().getY();
		if ((posX+deplacement > 0) && (posX+deplacement < this.zone.getTaille())) 
		{				// si le déplacement est dans la zone de jeux le le faire sinon ne rien faire															
			try
			{
				if((this.zone.contenu(posX+deplacement,posY)) == Zone.ENNEMI)
				{			// si l'élément à la position futur est un ennemi => perdre une vie puis déplacement
					this.zone.modification(posX,posY,Zone.VIDE);
					this.zone.modification(posX+deplacement,posY,Zone.JOUEUR);
					this.vieMoins();
					this.shipJoueur.translate(deplacement,0);
				}
				else
				{			// sinon déplacement
					this.zone.modification(posX,posY,Zone.VIDE);
					this.zone.modification(posX+deplacement,posY,Zone.JOUEUR);
					this.shipJoueur.translate(deplacement,0);
				}
			}
			catch (HorsZoneException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
	/**
	 * Débuter une partie  
	 */
	public void start()   
	{	
		Affichage affichage = new Affichage();
		int deplacement;
		int i = 0;
		while (this.vies != 0)
		{	
			if (i == 0)
			{
				this.zone.modification((int)( Math.random()*( (this.zone.getTaille()-1) + 1 ) ) + 0,0,Zone.ENNEMI);
				i = 1;
			}
			else
			{
				i =0;
			}
			// Déplacement => gestion collision	
			deplacement = this.joueur.getDeplacement();
			deplacement(deplacement);
			// Scroll => gestion collision
		    boolean colision = this.zone.scroll();
		    if (colision == true)
			{
				this.vieMoins();
			}
		    // Affichage
		    affichage.afficher(this.zone.getZone());
			pause(250);
		}
	}
	
}
