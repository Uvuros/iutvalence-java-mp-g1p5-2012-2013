package fr.iutvalence.java.projets.shootemup;

/**
 * Classe partie
 * 
 * @author Deguitre & Pignet
 * 
 */
public class PartieScrollingAsynchroneDeplacementAsynchrone implements Scrollable
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
		 * zone de jeu sur laquelle évoluent les vaisseaux
		 */
		public Zone zone;

		/**
		 * Représente le nombre de vie du joueur
		 */
		public int vies;
		
		/**
		 * Joueur représente les interactions entre le joueur et la partie 
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
		public PartieScrollingAsynchroneDeplacementAsynchrone(String pseudo, Joueur joueur, Affichage affichage)
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
		 * @param move représente la direction dans laquel veut aller le joueur         
		 * @return false si collision true sinon
		 */
		private boolean deplacement(Direction move)
		{
			int x = 0;
			int y = 0;
			switch (move)
			// Uniquement deux posssibilité de mouvements pour l'instant
			{						// Deplacement en x de 1 ou -1
				case FIXE:
					x = 0;
					y=0;
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
					y=1;
					break;
				default:
					x=0;
					y=0;
			}
			int posX = this.shipJoueur.getPosition().getX();
			int posY = this.shipJoueur.getPosition().getY();
			if (x != 0)
			{
				if ((posX + x > 0) && (posX + x < this.zone.getTaille()))
				{				// si le déplacement est dans la zone de jeux le le faire sinon ne rien faire
					try
					{
						if ((this.zone.contenu(posX + x, posY)) == ContenuZone.ENNEMI)
						{			// si l'élément à la position futur est un ennemi => perdre une vie puis déplacement
							this.zone.modification(posX, posY, ContenuZone.VIDE);
							this.zone.modification(posX + x, posY, ContenuZone.JOUEUR);
							this.shipJoueur.translate(x, 0);
							return false; // utiliser une constante
						}
						else
						{			// sinon déplacement
							this.zone.modification(posX, posY, ContenuZone.VIDE);
							this.zone.modification(posX + x, posY, ContenuZone.JOUEUR);
							this.shipJoueur.translate(x, 0);
						}
					}
					catch (HorsZoneException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
				}
				return true;
			}
			else
			{
				if(y != 0)
				{
					if ((posY + y > 0) && (posY + y < this.zone.getTaille()))
					{				// si le déplacement est dans la zone de jeux le le faire sinon ne rien faire
						try
						{
							if ((this.zone.contenu(posX, posY + y)) == ContenuZone.ENNEMI)
							{			// si l'élément à la position futur est un ennemi => perdre une vie puis déplacement
								this.zone.modification(posX, posY, ContenuZone.VIDE);
								this.zone.modification(posX, posY + y, ContenuZone.JOUEUR);
								this.shipJoueur.translate(0, y);
								return false; // utiliser une constante
							}
							else
							{			// sinon déplacement
								this.zone.modification(posX, posY, ContenuZone.VIDE);
								this.zone.modification(posX, posY + y, ContenuZone.JOUEUR);
								this.shipJoueur.translate(0, y);
							}
						}
						catch (HorsZoneException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
					}
					return true;
				}
			}
			return true;
		}

		/**
		 * Débuter une partie
		 */
		public void start()
		{
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
				pause(250);
			}
		}
		
		/* (non-Javadoc)
		 * @see fr.iutvalence.java.projets.shootemup.Scrollable#scroll()
		 */
		public boolean mouvement(Direction move)
		{
			if (! this.deplacement(move))
			{	
				this.vieMoins();
				this.affichage.afficherZone(this.zone.getZone());
				if(this.vies == 0)
					return false;
				else
					return true;
			}
			this.affichage.afficherZone(this.zone.getZone());
			if(this.vies == 0)
				return false;
			else
				return true;
			
		}

		public boolean scroll()
		{
			if (this.zone.scroll())
			{
				boolean res = this.vieMoins();
				this.affichage.afficherZone(this.zone.getZone());
				return res;
			}
			this.affichage.afficherZone(this.zone.getZone());
			return true;
		}
		
	}
