package fr.iutvalence.java.projets.shootemup;

/**
 * Classe partie
 * 
 * @author Deguitre & Pignet
 * 
 */
public abstract class Partie implements Scrollable 
{
	/**
	 * Taille par défaut de la zone de jeux
	 */
	public static final int TAILLEZONE = 14;

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
	protected Ship shipJoueur;

	/**
	 * zone de jeu sur laquelle évoluent les vaisseaux
	 */
	protected Zone zone;

	/**
	 * Représente le score du joueur
	 */
	protected int score;

	/**
	 * Représente le nombre de vie du joueur
	 */
	protected int vies;

	/**
	 * Joueur représente les interactions entre le joueur et la partie
	 */
	protected Joueur joueur;

	/**
	 * Pseudo du joueur
	 */
	protected String pseudo;

	/**
	 * Affichage (visualisation de la partie)
	 */
	protected Affichage affichage;
	protected InterfaceHighScore interfaceHighScore;
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
	public Partie(String pseudo, Joueur joueur, Affichage affichage)
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
		zone.modification(player.getPosition(), player.getType());
		// this.liste = new Ship[100];
		this.affichage.notificationNbViesRestantes(this.vies);
	}
	/**
	 * @param pseudo
	 * @param joueur
	 */
	public Partie(String pseudo, Joueur joueur, InterfaceHighScore interfaceHighScore)
	{
		this.joueur = joueur;
		this.score = 0;
		this.vies = 5;
		this.pseudo = pseudo;
		Ship player = new Ship(TAILLEZONE);
		this.shipJoueur = player;
		Zone zone = new Zone(TAILLEZONE);
		this.zone = zone;
		zone.modification(player.getPosition(), player.getType());
		this.interfaceHighScore = interfaceHighScore;
		// this.liste = new Ship[100];
	}
	/**
	 * @param pseudo
	 * @param joueur
	 */
	public Partie(String pseudo, Joueur joueur)
	{
		this.joueur = joueur;
		this.score = 0;
		this.vies = 5;
		this.pseudo = pseudo;
		Ship player = new Ship(TAILLEZONE);
		this.shipJoueur = player;
		Zone zone = new Zone(TAILLEZONE);
		this.zone = zone;
		zone.modification(player.getPosition(), player.getType());
		// this.liste = new Ship[100];
	}
	/**
	 * Fonction permettant d'enlever une vie et retourne l'état du joueur(VIVANT ou MORT)
	 * 
	 * @return renvois <tt>VIVANT</tt> s'il reste des vie à l'utilisateur sinon <tt>MORT</tt> et détruit le vaisseaux du
	 *         joueur
	 */
	protected boolean vieMoins()
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
	 * Ajout de points Nombre de points à ajouter
	 * @param score score à ajouter au score total
	 */
	protected void ajoutPoints(int score)
	{
		this.score = this.score + score;
	}

	/**
	 * permet d'effectuer une pause
	 * 
	 * @param delai
	 *            nombre de milliseconde à attendre
	 */
	protected void pause(long delai)
	{
		try
		{
			Thread.sleep(delai);
		}
		catch (InterruptedException e)
		{
			// Ignorer
		}

	}

	/**
	 * fonction permettant de savoir si le joueur est encore en vie
	 * 
	 * @return true si en vie false sinon
	 */
	protected boolean enVie()
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
	 * @return false si collision true sinon
	 */
	protected boolean deplacement(Direction move)
	{
		int x = 0;
		int y = 0;
		switch (move)
		// Uniquement deux posssibilité de mouvements pour l'instant
		{						// Deplacement en x de 1 ou -1
			case FIXE:
				x = 0;
				y = 0;
				break;
			case GAUCHE:
				x = -1;
				break;
			case DROITE:
				x = 1;
				break;
			case HAUT:
				y = -1;
				break;
			case BAS:
				y = 1;
				break;
			default:
				x = 0;
				y = 0;
		}

		Position oldPos = this.shipJoueur.getPosition();
		Position nouvPos = oldPos.translate(x, y);

		if (this.zone.estDansZone(nouvPos))
		{
			this.shipJoueur.translateTo(nouvPos);

			try
			{
				if (this.zone.contenu(oldPos) == ContenuZone.MISSILE_VAISSEAU)
				{
					this.zone.modification(oldPos, ContenuZone.VIDE);
				}
				else
				{
					this.zone.modification(oldPos, ContenuZone.VIDE);
				}
				boolean contenuzone = (this.zone.contenu(nouvPos) == ContenuZone.ENNEMI);	
				if (this.zone.contenu(nouvPos) == ContenuZone.MISSILE)
				{
					this.zone.modification(nouvPos, ContenuZone.MISSILE_VAISSEAU);
				}
				else
				{
					this.zone.modification(nouvPos, ContenuZone.JOUEUR);
				}
				return !(contenuzone);
			}
			catch (HorsZoneException e)
			{
				// on peut ignorer car le test a été effectué avant
			}
		}
		return true;
	}

	/**
	 * @param move
	 *            direction dans laquel bouger
	 * @return retourne false si le joueur meurt suite a se déplacement true sinon
	 */
	protected boolean mouvement(Direction move)
	{
		if (!(this.deplacement(move)))
			this.vieMoins();
			this.affichage.notificationNbViesRestantes(this.vies);
		this.affichage.afficherZone(this.zone.getZone());
		return (this.vies > 0);
	}

	public boolean scroll()
	{
		this.ajoutPoints((int)((1-(double)this.shipJoueur.getPosition().getY()/this.zone.getTaille())*10));
		this.affichage.notificationScore(this.score);
		if (this.zone.scroll())
			this.vieMoins();
			this.affichage.notificationNbViesRestantes(this.vies);
		this.affichage.afficherZone(this.zone.getZone());
		return this.enVie();
	}

	/**
	 * Débuter une partie
	 */
	public abstract void start();

}
