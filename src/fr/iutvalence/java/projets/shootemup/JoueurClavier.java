package fr.iutvalence.java.projets.shootemup;

// FIXME préciser la particularité de cette implementation
/**
 * Classe de controle interface entre l'utilisateur et la partie
 * 
 * @author deguitre & Pignet
 * 
 */
public class JoueurClavier implements Joueur
{
	/**
	 * @see fr.iutvalence.java.projets.shootemup.Joueur#getDeplacement()
	 * @Override
	 */
	public Direction getDeplacement()
	{
		// FIXME pour l'instant utiliser un Scanner
		return Direction.FIXE;
	}
}
