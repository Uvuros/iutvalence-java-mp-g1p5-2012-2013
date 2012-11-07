package fr.iutvalence.java.projets.shootemup;

/**
 * Interface de controle, permet d'obtenir un deplacement
 * 
 * @author deguitre & Pignet
 * 
 */
public interface Joueur
{

	/**
	 * Obtenir la direction dans laquelle le joueur souhaite se déplacer
	 * 
	 * @return la direction dans laquelle le joueur souhaite se déplacerr
	 */
	public Direction getDeplacement();

}