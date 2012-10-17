package fr.iutvalence.java.projets.shootemup;


// FIXME (FIXED) détailler le commentaire
/**
 * Classe de controle
 * interface entre l'utilisateur et la partie
 * @author deguitre & Pignet
 * 
 */
public class JoueurAlea implements Joueur
{
	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projets.shootemup.Joueur#getDeplacement()
	 */
	@Override
	public int getDeplacement()
	{
		return (int)(Math.random() *3); 
	}
	
}
