package fr.iutvalence.java.projets.shootemup;


/**
 * @author deguitre & Pignet
 * Affichage de la zone de jeux
 */
public class Affichage
{
	/**
	 * Zone de jeux à afficher
	 */
	public Zone zone;
	
	
	/**
	 * initialisation de l'affichage, place zone dans this.zone
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
