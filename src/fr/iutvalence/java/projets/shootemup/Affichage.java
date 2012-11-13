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
	 * @param nbViesRestantes
	 *            vies restantes à afficher
	 */
	public void notificationNbViesRestantes(int nbViesRestantes);

}
