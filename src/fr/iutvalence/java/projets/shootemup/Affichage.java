package fr.iutvalence.java.projets.shootemup;


/**
 * Affichage de la zone de jeu
 * @author deguitre & Pignet
 * 
 */
public class Affichage
{
	/**
	 * Zone de jeu à afficher
	 */
	public Zone zone;
	
	
	// FIXME (FIXED) corriger le commentaire (ne pas décrire l'implémentation 
	/**
	 * initialisation de l'affichage
	 * @param zone à afficher
	 */
	public Affichage(Zone zone)
	{
		this.zone = zone;
	}
	/**
	 * Affichage de la zone
	 */
	public void afficher()
	{
		System.out.println(this.zone);
		System.out.println(); 
	}
}
