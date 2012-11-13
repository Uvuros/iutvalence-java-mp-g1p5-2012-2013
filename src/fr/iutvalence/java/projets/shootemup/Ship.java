package fr.iutvalence.java.projets.shootemup;

//FIXME si les vaisseaux ennemis se distinguent du vaisseau du joueur par le fait qu'ils peuvent sortir de la zone de jeu ...
//FIXME .. il faudrait utiliser l'héritage ce qui simplifierait l'écriture de "deplacement" 
// Pas encore utilisé 

/**
 * Gestion des unitées
 * 
 * @author Deguitre & Pignet
 * 
 */
public class Ship
{
	/**
	 * valeur des coordonnées x ou y max
	 */
	public static final int MAX = 100;

	/**
	 * valeur du vaisseau joueur
	 */

	public static final int JOUEUR = 1;

	/**
	 * valeur des vaisseaux de ennemis
	 */
	public static final int ENNEMI = 2;

	/**
	 * valeur des coordonnées x ou y min
	 */
	public static final int MIN = 100;

	/**
	 * Valeur représentant la mort du joueur
	 */
	public static final boolean MORT = false;

	/**
	 * Valeur indiquant que le joueur est en vie
	 */
	public static final boolean VIVANT = true;

	/**
	 * Position du vaisseau
	 */
	private Position position;

	/**
	 * Représente le type de vaisseau
	 */
	private ContenuZone typeShip;

	/**
	 * Etat du vaisseau, true pour VIVANT, false pour MORT
	 */
	private boolean etat;

	/**
	 * Initialise un vaisseau de type Joueur (type 1, situé au centre de la zone de jeux, etat = vivant)
	 * 
	 * @param maxzone
	 *            taille maximum de la zone de jeux, permet de placer le vaisseau joueur au center, en bas.
	 */
	public Ship(int maxzone)
	{

		this.etat = VIVANT;
		this.position = new Position(maxzone / 2, maxzone - 1);
		// this.tir = false;
		this.typeShip = ContenuZone.JOUEUR;
	}

	/**
	 * Initialise un vaisseau de type ennemi (choix de la position de départ)
	 * 
	 * @param x
	 *            position sur l'axe x
	 * @param y
	 *            position sur l'axe y
	 * @param terrain
	 *            Zone de jeux
	 */
	public Ship(int x, int y, Zone terrain)
	{
		this.etat = VIVANT;
		this.position = new Position(x, y);
		// this.tir = false;
		this.typeShip = ContenuZone.ENNEMI;

		terrain.modification(this.position, this.typeShip);
	}

	/**
	 * Permet d'obtenir la position du vaisseau
	 * 
	 * @return la position du vaisseau
	 */
	public Position getPosition()
	{
		return this.position;
	}

	/**
	 * permet de changer de position
	 * 
	 * @param p
	 *            position vers laquelle translater
	 */
	public void translateTo(Position p)
	{
		this.position = p;
	}

	/**
	 * fonction permettant de détruire l'unitée
	 */
	public void detruire()
	{
		this.etat = MORT;
	}

	/**
	 * Permet d'obtenir le type du vaisseau
	 * 
	 * @return le type du vaisseau
	 */
	public ContenuZone getType()
	{
		return this.typeShip;
	}

	/**
	 * Permet d'otenir l'etat du vaisseau
	 * 
	 * @return l'etat du vaisseau
	 */
	public boolean getEtat()
	{
		return this.etat;
	}
	/*
	 * public void tir() { if (this.tir == true) { this.tir = false; } else { this.tir = true; } }
	 */

}
