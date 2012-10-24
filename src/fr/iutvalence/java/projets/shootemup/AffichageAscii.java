package fr.iutvalence.java.projets.shootemup;

// FIXME détailler le commentaire
/**
 * Affichage de la zone de jeu
 * 
 * @author deguitre & Pignet
 * 
 */
public class AffichageAscii implements Affichage
{
	/**
	 * @see fr.iutvalence.java.projets.shootemup.Affichage#afficher(int[][])
	 */
	public void afficher(int[][] zone)
	{
		String result = "";
		// ...
		for (int x = 0; x < zone.length; x++)
		{
			for (int y = 0; y < zone[x].length; y++)
			{
				switch (zone[x][y])
				{
					// FIXME utiliser des constantes
					case 0:
						result = result + " ";
						break;
					case 2:		// ennemi représentés par |
						result = result + "|";
						break;
					case 1:		// Vaisseau joueur représenté par A
						result = result + "A";
						break;
					default:
						result = result + "?";
				}

			}
			result = result + "\r\n";
		}
		result += "-------------------------";
		System.out.println(result);
		System.out.println();
	}
}
