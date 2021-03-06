package fr.iutvalence.java.projets.shootemup;

/**
 * interface d'affichage, affiche un tableaux à deux dimenssions
 * 
 * @author deguitre & Pignet
 * 
 */
public interface Affichage
{
	/**
	 * Affichage de la zone
	 * 
	 * @param zone
	 *            zone que l'on veut afficher
	 */
	public void afficherZone(ContenuZone[][] zone);
	/**
	 * Affichage de la zone
	 * 
	 * @param zone
	 *            zone que l'on veut afficher
	 */
	public void afficherTir(ContenuZone[][] zone,boolean debut);

	/**
	 * @param nbViesRestantes
	 *            vies restantes à afficher
	 */
	public void notificationNbViesRestantes(int nbViesRestantes);
	/**
	 * @param score à afficher
	 */
	public void notificationScore(int score);
	
	public void bestScore(Score score);

}
