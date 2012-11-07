package fr.iutvalence.java.projets.shootemup;

/**
 * Classe de controle, génère des choix aléatoires 
 * 
 * @author deguitre & Pignet
 * 
 */
public class JoueurAlea implements Joueur
{
	/**
	 * Retourne une direction choisie equiprobablement parmi les valeurs possibles.
	 * @see fr.iutvalence.java.projets.shootemup.Joueur#getDeplacement()
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
