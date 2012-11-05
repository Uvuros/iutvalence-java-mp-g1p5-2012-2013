package fr.iutvalence.java.projets.shootemup;

/**
 * Classe partie
 * 
 * @author Deguitre & Pignet
 * 
 */
public class PartieScrollingAsynchroneDeplacementSynchrone implements Scrollable
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

	// FIXME (FIXED)corriger le commentaire (à discuter)
	/**
	 * zone de jeux sur laquelle évoluent les vaisseaux
	 */
	public Zone zone;

	/**
	 * Représente le nombre de vie du joueur
	 */
	public int vies;
	
	// FIXME (FIXED ?)corriger le commentaire
	/**
	 * Joueur représente les interaction entre le joueur et la partie 
	 */
	private Joueur joueur;
	
	/**
	 * Affichage (visualisation de la partie)
	 */
	private Affichage affichage;
	
	/*
	 * /** Liste des ships créer A utiliser quand nous utiliserons des objets ship ennemi
	 */
	// public Ship[] liste;
	
	/**
	 * Pseudo du joueur
	 */
	public String pseudo;

	/**
	 * Initialisation d'une partie met le score à 0, le nombre de vies à 5, crée un vaisseau joueur et la zone de jeux.
	 * 
	 * @param pseudo
	 *            du joueur souhaité
	 * @param joueur
	 *            interface permettant de controler la partie
	 * @param affichage
	 *            interface permettant l'affichage de la partie
	 */
	public PartieScrollingAsynchroneDeplacementSynchrone(String pseudo, Joueur joueur, Affichage affichage)
	{
		this.affichage = affichage;
		this.joueur = joueur;
		this.score = 0;
		this.vies = 5;
		this.pseudo = pseudo;
		Ship player = new Ship(TAILLEZONE);
		this.shipJoueur = player;
		Zone zone = new Zone(TAILLEZONE);
		this.zone = zone;
		zone.modification(player.getPosition().getX(), player.getPosition().getY(), player.getType());
		// this.liste = new Ship[100];
		this.affichage.notificationNbViesRestantes(this.vies);
	}

	/**
	 * Fonction permettant d'enlever une vie et retourne l'état du joueur(VIVANT ou MORT)
	 * @return renvois <tt>VIVANT</tt> s'il reste des vie à l'utilisateur sinon <tt>MORT</tt> et détruit le vaisseaux du
	 *         joueur
	 */
	public boolean vieMoins()
	{
		if (this.vies != 0)
		{
			this.vies = this.vies - 1;
			this.affichage.notificationNbViesRestantes(this.vies);
			if (this.vies == 0)
			{
				this.shipJoueur.detruire();
			}
		}
		return this.shipJoueur.getEtat();

	}

	/**
	 * Ajout de points
	 *            Nombre de points à ajouter
	 */
	public void ajoutPoints()
	{
		this.score = this.score + 100;
	}

	/**
	 * permet d'effectuer une pause
	 * 
	 * @param delai
	 *            nombre de milliseconde à attendre
	 */
	public void pause(long delai)
	{
		long t = System.currentTimeMillis();
		while ((System.currentTimeMillis() - t) < delai)
		{

		}
	}
	/**
	 * @return l'état du vaisseau sous forme de booléen 
	 */
	public boolean enVie()
	{
		if (this.vies != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * déplace le ship joueur
	 * 
	 * @param move
	 *            représente la direction dans laquel veut aller le joueur
	 */
	private void deplacement(Direction move)
	{
		int deplacement;
		switch (move)
		// Uniquement deux posssibilité de mouvements pour l'instant
		{						// Deplacement en x de 1 ou -1
			case FIXE:
				deplacement = 0;
				break;
			case GAUCHE:
				deplacement = -1;
				break;
			case DROITE:
				deplacement = 1;
				break;
			default:
				deplacement = 0;
		}
		int posX = this.shipJoueur.getPosition().getX();
		int posY = this.shipJoueur.getPosition().getY();
		if ((posX + deplacement > 0) && (posX + deplacement < this.zone.getTaille()))
		{				// si le déplacement est dans la zone de jeux le le faire sinon ne rien faire
			try
			{
				if ((this.zone.contenu(posX + deplacement, posY)) == ContenuZone.ENNEMI)
				{			// si l'élément à la position futur est un ennemi => perdre une vie puis déplacement
					this.zone.modification(posX, posY, ContenuZone.VIDE);
					this.zone.modification(posX + deplacement, posY, ContenuZone.JOUEUR);
					this.vieMoins();
					this.shipJoueur.translate(deplacement, 0);
				}
				else
				{			// sinon déplacement
					this.zone.modification(posX, posY, ContenuZone.VIDE);
					this.zone.modification(posX + deplacement, posY, ContenuZone.JOUEUR);
					this.shipJoueur.translate(deplacement, 0);
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
		Direction deplacement;
		int i = 0;
		while (this.vies != 0)
		{
			if (i == 0)
			{
				this.zone.modification((int) (Math.random() * ((this.zone.getTaille() - 1) + 1)) + 0, 0, ContenuZone.ENNEMI);
				i = 1;
			}
			else
			{
				i = 0;
			}
			// Déplacement => gestion collision
			deplacement = this.joueur.getDeplacement();
			deplacement(deplacement);
			// Affichage
			this.affichage.afficherZone(this.zone.getZone());
			pause(250);
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projets.shootemup.Scrollable#scroll()
	 */
	@Override
	public boolean scroll()
	{
		if (this.zone.scroll())
		{
			this.affichage.afficherZone(this.zone.getZone());
			return this.vieMoins();
		}
		this.affichage.afficherZone(this.zone.getZone());
		return true;
	}

	@Override
	public boolean mouvement(Direction move)
	{
		return false;
	}
	
}
