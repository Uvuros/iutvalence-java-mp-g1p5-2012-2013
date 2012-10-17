package fr.iutvalence.java.projets.shootemup;


// FIXME détailler le commentaire
/**
 * Classe de controle
 * @author deguitre & Pignet
 * 
 */
public class Joueur
{
	// FIXME détailler le commentaire (constantes ?)
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
