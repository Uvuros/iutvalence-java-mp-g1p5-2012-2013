package fr.iutvalence.java.projets.shootemup;

/**
 * @author deguitre & Pignet
 * Classe de controle
 */
public class Joueur
{
	/**
	 * entier représentant le déplacement du joueur
	 */
	public int deplacement;
	
	/**
	 * Initialise Joueur, deplacement = 0 => ne bouge pas
	 */
	public Joueur()
	{
		this.deplacement = 0;
	}
	/**
	 * Déplacement du joueur
	 * @return le déplacement
	 */
	public int getDeplacement()
	{
		int i = (int)(Math.random() *3); 
		return i;
	}
	
	
}
