package fr.iutvalence.java.projets.shootemup;

// FIXME (FIXED) détailler le commentaire
/**
 * Classe de controle, génére des choix aléatoire 
 * 
 * @author deguitre & Pignet
 * 
 */
public class JoueurAlea implements Joueur
{
	/**
	 * 
	 * @see fr.iutvalence.java.projets.shootemup.Joueur#getDeplacement()
	 * @Override
	 */
	
	public Direction getDeplacement()
	{
		int alea = (int) (Math.random() * 5);
		switch (alea)
		{
			case 0: return Direction.FIXE;
			
			case 1: return Direction.GAUCHE;

			case 2 : return Direction.DROITE;
			
			default: return Direction.FIXE;
		}
	}

}
