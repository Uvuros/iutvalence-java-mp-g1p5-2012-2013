package fr.iutvalence.java.projets.shootemup;

/**
 * enumération des différents contenu de zone possibles
 * 
 * @author deguitre & Pignet
 * 
 */
public enum ContenuZone
{
	/**
	 * case vide
	 */
	VIDE,
	/**
	 * case avec un joueur
	 */
	JOUEUR,
	/**
	 * case avec un ennemi
	 */
	ENNEMI,
	/**
	 * case contenant un missile et un vaisseau
	 */
	MISSILE_VAISSEAU,
	/**
	 * case avec un missile joueur
	 */
	MISSILE;
}
