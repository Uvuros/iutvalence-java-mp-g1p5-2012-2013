package fr.iutvalence.java.projets.shootemup;

/**
 * interface d'affichage, affiche un tableaux à deux dimenssions 
 * 
 * @author deguitre & Pignet
 * 
 */
public interface Affichage
{
	// FIXME (FIXED) compléter le commentaire (param)
	/**
	 * Affichage de la zone
	 * 
	 * @param zone que l'ont veut afficher
	 */
	public void afficherZone(ContenuZone[][] zone);
	
	/**
	 * @param nbViesRestantes
	 */
	public void notificationNbViesRestantes(int nbViesRestantes);
	
}
