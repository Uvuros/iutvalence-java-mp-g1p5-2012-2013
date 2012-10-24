package fr.iutvalence.java.projets.shootemup;

// FIXME (FIXED) détailler le commentaire
/**
 * Interface de controle, permet d'obtenir un deplacement
 * 
 * @author deguitre & Pignet
 * 
 */
public interface Joueur
{

	// FIXME (FIXED) corriger le commentaire (l'interface ne spécifie pas la réalisation du service)
	// FIXME (FIXED) définir une énumération pour les différentes directions de déplacement
	/**
	 * Renvoie un chiffre représentant le déplacement du joueur
	 * 
	 * @return représentation du déplacement du joueur
	 */
	public Direction getDeplacement();

}