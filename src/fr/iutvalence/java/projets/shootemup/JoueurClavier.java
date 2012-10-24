package fr.iutvalence.java.projets.shootemup;

/**
 * Classe de controle
 * interface entre l'utilisateur et la partie
 * @author deguitre & Pignet
 * 
 */
public class JoueurClavier implements Joueur
{
	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projets.shootemup.Joueur#getDeplacement()
	 * @Override
	 */
	public Direction getDeplacement()
	{
		return Direction.FIXE; 
	}
}
